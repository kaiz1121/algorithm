package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 上午11:07 2021/3/31.
 */
public class VolatileTest {
	private volatile int inc = 1;
	final  String string = "fff";
//	private AtomicInteger atomicInteger = new AtomicInteger(1);
	public void increace() {
		inc++;
	}

	ReentrantLock reentrantLock = new ReentrantLock();

	ExecutorService executorService = Executors.newFixedThreadPool(3);
}
