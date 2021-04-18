package ratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Title: </p>
 * <p>Description:普通技术器限流-单窗口 </p>
 *
 * @author kaiz
 * @date 上午10:13 2021/4/9.
 */
public class CounterRateLimit implements RateLimit , Runnable {

	/**
	 * 阈值
	 */
	private Integer limitCount;

	/**
	 * 当前通过请求数
	 */
	private AtomicInteger passCount;

	/**
	 * 统计时间间隔
	 */
	private long period;
	private TimeUnit timeUnit;

	private ScheduledExecutorService scheduledExecutorService;


	public CounterRateLimit(Integer limitCount) {
		this(limitCount, 1000, TimeUnit.MILLISECONDS);
	}

	public CounterRateLimit(Integer limitCount, long period, TimeUnit timeUnit) {
		this.limitCount = limitCount;
		this.period = period;
		this.timeUnit = timeUnit;
		passCount = new AtomicInteger(0);
		this.startResetTask();
	}

	@Override
	public boolean canPass() throws BlockException {
		if (passCount.incrementAndGet() > limitCount) {
			throw new BlockException();
		}
		return true;
	}

	private void startResetTask() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(this, 0, period, timeUnit);
	}

	@Override
	public void run() {
		passCount.set(0);
	}
}
