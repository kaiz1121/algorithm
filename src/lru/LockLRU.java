package lru;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 下午9:57 2021/4/12.
 */
public class LockLRU<K, V> {
	public static void main(String[] args) {
		LockLRU<String, String> lru = new LockLRU<>(3);
		lru.put("a", "a", 0);
		lru.put("b","b",0);
		lru.put("a", "a", 0);
		lru.put("c", "c", 1);
		lru.put("d", "d", 2);
		lru.put("e", "e", 0);

		for (Map.Entry<String, String> m : lru.concurrentHashMap.entrySet()) {
			System.out.println("key:" + m.getKey() + ",value:" + m.getValue());
		}
	}


	//存放数据
	private ConcurrentHashMap<K, V> concurrentHashMap;
	//用于保存最近最少使用
	private ConcurrentLinkedQueue<K> concurrentLinkedQueue;
	//最大容量
	private final int size;
	//用于检查失效时间
	private ScheduledExecutorService scheduledExecutorService;
	//读写锁控制
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();;
	//读锁
	private Lock readLock = readWriteLock.readLock();
	//写锁
	private Lock writeLock = readWriteLock.writeLock();

	public LockLRU(int size) {
		this.size = size;
		concurrentHashMap = new ConcurrentHashMap<>(size);
		concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
		scheduledExecutorService = new ScheduledThreadPoolExecutor(3);
	}

	public V put(K k, V v, long expireTime) {
		writeLock.lock();
		try {
			//判断元素是否存在，存在则更新，并更新队列，返回更新值
			if (concurrentHashMap.containsKey(k)) {
				concurrentHashMap.put(k, v);
				moveTail(k);
				return v;
			}
			//元素不存在，先判断大小是否超出最大size
			if (concurrentHashMap.size() + 1 > size) {
				//移除最不经常使用的元素
				removeOldestKey();
			}
			//新增值
			concurrentHashMap.put(k, v);
			concurrentLinkedQueue.offer(k);
			//判断是否有失效时间
			if (expireTime > 0) {
				removeExpireKey(k, expireTime);
			}
		}finally {
			writeLock.unlock();
		}
		return v;
	}

	public V get(K k) {
		readLock.lock();
		try {
			if (concurrentHashMap.containsKey(k)) {
				moveTail(k);
				return concurrentHashMap.get(k);
			}
		}finally {
			readLock.unlock();
		}
		return null;
	}

	public V remove(K k) {
		writeLock.lock();
		try {
			if (concurrentHashMap.containsKey(k)) {
				concurrentLinkedQueue.remove(k);
				return concurrentHashMap.remove(k);
			}
		}finally {
			writeLock.unlock();
		}
		return null;
	}

	/**
	 * 将元素移动到最后
	 */
	public void moveTail(K key) {
		concurrentLinkedQueue.remove(key);
		concurrentLinkedQueue.offer(key);

	}

	/**
	 * 删除最老的key
	 */
	public void removeOldestKey() {
		K k = concurrentLinkedQueue.poll();
		if (k != null) {
			concurrentHashMap.remove(k);
		}
	}

	/**
	 * 删除超时key
	 */
	public void removeExpireKey(K k, long expireTime) {
		scheduledExecutorService.schedule(() -> {
			System.out.println("清除了key:" + k);
			concurrentHashMap.remove(k);
			concurrentLinkedQueue.remove(k);
		}, expireTime, TimeUnit.MILLISECONDS);
	}
}
