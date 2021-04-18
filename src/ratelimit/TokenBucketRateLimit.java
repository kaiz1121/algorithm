package ratelimit;

import com.sun.tools.javac.util.StringUtils;

import java.util.concurrent.*;

/**
 * <p>Title: </p>
 * <p>Description: 令牌桶限流</p>
 *
 * @author kaiz
 * @date 上午10:45 2021/4/9.
 */
public class TokenBucketRateLimit implements RateLimit, Runnable{
	/**
	 * token 生成 速率 （每秒）
	 */
	private Integer tokenLimitSecond;

	/**
	 * 令牌桶队列
	 */
	private BlockingQueue<String /* token */> tokenBucket;

	private static final String TOKEN = "__token__";

	private ScheduledExecutorService scheduledExecutorService;

	public TokenBucketRateLimit(Integer bucketSize, Integer tokenLimitSecond) {
		this.tokenLimitSecond = tokenLimitSecond;
		this.tokenBucket = new LinkedBlockingDeque<>(bucketSize);

		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		long interval = (1000 * 1000 * 1000) / tokenLimitSecond;
		scheduledExecutorService.scheduleAtFixedRate(this, 0, interval, TimeUnit.NANOSECONDS);
	}

	@Override
	public boolean canPass() throws BlockException {
		String token = tokenBucket.poll();
		if (token == null || "".equals(token)) {
			throw new BlockException();
		}
		return true;
	}

	@Override
	public void run() {
		if (tokenBucket.remainingCapacity() == 0) {
			return;
		}
		tokenBucket.offer(TOKEN);
	}
}
