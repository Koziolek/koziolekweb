package pl.koziolekweb.lazyparams;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Hello world!
 */
public class App {

	private LongOpService los;

	public App() {
		los = new LongOpService();
	}

	public static void main(String[] args) {
		final App a = new App();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			a.someOp(r.nextInt(10), new Callable<Integer>() {
				@Override
				public Integer call() {
					return a.los.longOp();
				}
			});
		}
	}

	public void someOp(int param, Callable<Integer> longOpResult) {
		if (param < 2)
			try {
				System.out.println(longOpResult.call());
			} catch (Exception e) {
			}
		else
			System.out.println(param);
	}
}


class LongOpService {

	public int longOp() {
		System.out.println("Long Op!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 42;
	}
}