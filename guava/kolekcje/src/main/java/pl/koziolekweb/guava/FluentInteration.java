package pl.koziolekweb.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import pl.koziolekweb.guava.domain.ReportRequestRun;
import pl.koziolekweb.guava.domain.ReportRunHistory;
import pl.koziolekweb.guava.domain.RunReportStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.google.common.base.Predicates.compose;
import static com.google.common.base.Predicates.or;
import static pl.koziolekweb.guava.ReportRunHistoryStatusAsStringFunction.REPORT_RUN_HISTORY_STATUS_AS_STRING_FUNCTION;
import static pl.koziolekweb.guava.RunReportStatusEnumPredicate.IS_CANCELED;
import static pl.koziolekweb.guava.RunReportStatusEnumPredicate.IS_COMPLETED;
import static pl.koziolekweb.guava.RunReportStatusEnumPredicate.IS_FAILED;
import static pl.koziolekweb.guava.domain.RRHFactory.getListOf;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.CANCELED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.COMPLETED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.FAILED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.QUEUED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.RUNNING;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class FluentInteration {

	private static final Logger LOG = Logger.getLogger(FluentInteration.class.getName());

	public List<ReportRequestRun> rerunReports2(final List<Integer> runIds) {
		List<ReportRunHistory> reportRunsHistory = getReportRunsHistory(runIds);
		return FluentIterable.from(reportRunsHistory)
				.transform(new InConsumerFunction<>(new Consumer<ReportRunHistory>() {
					@Override
					public void consume(ReportRunHistory reportRunHistory) {
						LOG.info(reportRunHistory.toString());

					}
				}))
				.filter(
						compose(
								or(IS_CANCELED, IS_FAILED, IS_COMPLETED),
								REPORT_RUN_HISTORY_STATUS_AS_STRING_FUNCTION
						)
				)
				.filter(new Predicate<ReportRunHistory>() {
					@Override
					public boolean apply(ReportRunHistory input) {
						return runIds.contains(input.raportRunId);
					}
				})
				.filter(
						compose(
								or(IS_CANCELED, IS_FAILED),
								new Function<ReportRunHistory, String>() {
									@Override
									public String apply(ReportRunHistory input) {
										return input.status;
									}
								}
						)
				)
				.transform(new Function<ReportRunHistory, ReportRequestRun>() {
					@Override
					public ReportRequestRun apply(ReportRunHistory input) {
						return prepareReportRequest(input);
					}
				}).toList();
	}

	public List<ReportRequestRun> rerunReports(List<Integer> runIds) {
		List<ReportRunHistory> reportRunsHistory = getReportRunsHistory(runIds);
		List<ReportRequestRun> toReRun = new ArrayList<>();
		for (ReportRunHistory reportRunHistory : reportRunsHistory) {
			LOG.info(reportRunHistory.toString());
			if (reportRunHistory.status.equals(CANCELED.getStatusText())
					|| reportRunHistory.status.equals(FAILED.getStatusText())
					|| reportRunHistory.status.equals(COMPLETED.getStatusText())) {
				for (Integer runId : runIds) {
					if (runId.equals(reportRunHistory.raportRunId)) {
						if (reportRunHistory.status.equals(CANCELED.getStatusText())
								|| reportRunHistory.status.equals(FAILED.getStatusText())) {
							ReportRequestRun rrr = prepareReportRequest(reportRunHistory);
							toReRun.add(rrr);
						}
					}
				}
			}
		}
		return toReRun;
	}

	boolean is(ReportRunHistory reportRunHistory, RunReportStatusEnum e) {
		return reportRunHistory.status.equals(e.getStatusText());
	}

	private ReportRequestRun prepareReportRequest(ReportRunHistory reportRunHistory) {
		return new ReportRequestRun(reportRunHistory.raportRunId, reportRunHistory.params);
	}


	private List<ReportRunHistory> getReportRunsHistory(List<Integer> runIds) {
		List<ReportRunHistory> listOf = getListOf(2, QUEUED);
		listOf.addAll(getListOf(2, RUNNING));
		listOf.addAll(getListOf(3, COMPLETED));
		listOf.addAll(getListOf(3, CANCELED));
		listOf.addAll(getListOf(4, FAILED));
		return listOf;
	}

}
