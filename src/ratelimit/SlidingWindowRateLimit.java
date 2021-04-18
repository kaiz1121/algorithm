package ratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: </p>
 * <p>Description: 滑动窗口限流</p>
 *
 * @author kaiz
 * @date 上午10:28 2021/4/9.
 */
public class SlidingWindowRateLimit implements RateLimit, Runnable{
	/**
	阈值
	 */
	private final Integer limitCount;

	/**
	 * 当前通过的请求数
	 */
	private final AtomicInteger passCount;

	/**
	 * 窗口数
	 */
	private final Integer windowSize;

	/**
	 * 每个窗口时间间隔大小
	 */
	private final long windowPeriod;
	private final TimeUnit timeUnit;

	private Window[] windows;
	private Integer windowIndex = 0;

	private final Lock lock = new ReentrantLock();
	public SlidingWindowRateLimit(Integer limitCount) {
		//默认统计qps，窗口大小5
		this(limitCount, 5, 200, TimeUnit.MICROSECONDS);
	}
	public SlidingWindowRateLimit(Integer limitCount, Integer windowSize, Integer windowPeriod, TimeUnit timeUnit) {
		this.limitCount = limitCount;
		this.windowSize = windowSize;
		this.windowPeriod = windowPeriod;
		this.timeUnit = timeUnit;
		this.passCount = new AtomicInteger(0);

		//初始化所有创口
		this.initWindows(windowSize);
		//开始重置进程
		this.startResetTask();
	}


	private void initWindows(Integer windowSize){
		windows = new Window[windowSize];
		for(int i =0; i< windowSize; i++) {
			windows[i] = new Window();
		}
	}

	private ScheduledExecutorService scheduledExecutorService;
	private void startResetTask() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(this, windowPeriod, windowPeriod, timeUnit);
	}

	@Override
	public void run() {
		//获取当前窗口索引
		Integer curIndex = (windowIndex + 1) % windowSize;
		//重置当前窗口索引通过数量，并获取上一次通过数量
		Integer count = windows[curIndex].passCount.getAndSet(0);
		windowIndex = curIndex;
		//总通过数量 减去 当前窗口上次通过数量
		passCount.addAndGet(-count);
	}

	@Override
	public boolean canPass() throws BlockException {
		lock.lock();
		if (passCount.get() > limitCount) {
			throw new BlockException();
		}
		windows[windowIndex].passCount.incrementAndGet();
		passCount.incrementAndGet();
		lock.unlock();
		return true;
	}


	class Window {
		private AtomicInteger passCount;


		public Window() {
			this.passCount = new AtomicInteger(0);
		}
		public void setPassCount(AtomicInteger passCount) {
			this.passCount = passCount;
		}

		public AtomicInteger getPassCount() {
			return passCount;
		}

	}
}
