package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Title: LRU</p>
 * <p>Description: 基于linkedHashMap实现的简单lru算法，无超时时间，线程不安全</p>
 *
 * @author kaiz
 * @date 下午9:45 2021/4/12.
 */
public class LinkedHashMapLRU<K,V> extends LinkedHashMap<K,V> {

	private int size;

	public LinkedHashMapLRU(int size){
		super(size,0.75f,true);
		this.size = size;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return super.size() > size;
	}

	public static void main(String[] args) {
		LinkedHashMapLRU<String, String> lru = new LinkedHashMapLRU<>(2);
		lru.put("a", "a");
		lru.put("b","b");
		lru.put("a", "a");
		lru.put("c", "c");
		for (Map.Entry<String, String> m : lru.entrySet()) {
			System.out.println("key:" + m.getKey() + ",value:" + m.getValue());
		}
	}
}
