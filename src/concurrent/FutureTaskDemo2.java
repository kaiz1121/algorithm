package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 下午6:49 2021/3/31.
 */
public class FutureTaskDemo2 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		FutureTask<String> futureTask2 = new FutureTask<>(new Task2());
		FutureTask<String> futureTask1 = new FutureTask<>(new Task1(futureTask2));

		executorService.submit(futureTask1);
		executorService.submit(futureTask2);
		executorService.shutdown();

	}

	static class Task1 implements Callable<String> {

		private FutureTask<String> task2;

		public Task1(FutureTask<String> task2){
			this.task2 = task2;
		}

		@Override
		public String call() throws Exception {
			System.out.println("洗茶壶。。。。。");
			Thread.sleep(1000);
			System.out.println("烧水.......");
			Thread.sleep(3000);
			String result = task2.get();
			System.out.println("拿到task2的(),开始泡茶:" + result);
			return "泡好茶了！！";
		}
	}


	static class Task2 implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println("洗碗。。。。。");
			Thread.sleep(500);
			System.out.println("拿茶叶.......");
			Thread.sleep(200);
			return "拿好茶叶了！！！";
		}
	}
}
