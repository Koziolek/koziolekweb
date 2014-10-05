package pl.koziolekweb.guava;

import com.google.common.base.Function;
import pl.koziolekweb.guava.domain.ReportRunHistory;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class ReportRunHistoryStatusAsStringFunction implements Function<ReportRunHistory, String> {
	public static final ReportRunHistoryStatusAsStringFunction REPORT_RUN_HISTORY_STATUS_AS_STRING_FUNCTION
			= new ReportRunHistoryStatusAsStringFunction();

	private ReportRunHistoryStatusAsStringFunction(){}

	@Override
	public String apply(ReportRunHistory input) {
		return input.status;
	}
}
