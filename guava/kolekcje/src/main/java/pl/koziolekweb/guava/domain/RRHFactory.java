package pl.koziolekweb.guava.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class RRHFactory {

	private static AtomicInteger id = new AtomicInteger(1);

	private static Map<String, Object> params = new HashMap<>();

	static {
		params.put("a", "a");
		params.put("b", "b");
	}

	public static List<ReportRunHistory> getListOf(int nbrOf, RunReportStatusEnum type) {
		List<ReportRunHistory> reps = new ArrayList<ReportRunHistory>(nbrOf);
		for (int i = 0; i < nbrOf; i++) {
			reps.add(new ReportRunHistory(id.getAndIncrement(), type.getStatusText(), params));
		}
		return reps;
	}

	public static int current(){
		return id.get();
	}
}
