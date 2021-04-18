package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 下午5:35 2021/3/31.
 */
public class FutureDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		long start = System.currentTimeMillis();

		//等凉菜
		Callable c1 = () -> {
			Thread.sleep(1000);
			return "凉菜准备完毕";
		};
		FutureTask<String> task1 = new FutureTask<String>(c1);
		new Thread(task1).start();

		//等包子
//		Callable c2 = () -> {
//			Thread.sleep(1000*3);
//			return "包子准备完毕";
//		};
		FutureTask<String> task2 = new FutureTask<>(() -> {
			Thread.sleep(1000*3);
			return "包子准备完毕";
		});
		new Thread(task2).start();


		System.out.println(task1.get());
		System.out.println(task2.get());

		long end = System.currentTimeMillis();
		System.out.println("准备完毕时间："+(end-start));


	}
}
