package pl.koziolekweb.java8.collections;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class StatsListener extends TestListenerAdapter {

	private final Map<String, List<Long>> timesMap;

	public StatsListener() {
		timesMap = new HashMap<>();
		System.out.println("Listener działa");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		String testName = tr.getName();
		Long time = tr.getEndMillis() - tr.getStartMillis();
		if (!timesMap.containsKey(testName)) {
			timesMap.put(testName, new ArrayList<>(15));
		}
		timesMap.get(testName).add(time);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		try {
			System.setErr(new PrintStream("out.odp"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		timesMap.entrySet()
				.stream()
				.map(x -> new Object[]{x.getKey(),
						x.getValue()
								.stream()
								.map(this::inSeconds)
								.mapToDouble(Double::doubleValue)
								.average().orElse(-1.)})
				.map(Arrays::toString)
				.forEach(System.err::println);
	}

	private double inSeconds(long l){
		return l/1000;
	}
}
