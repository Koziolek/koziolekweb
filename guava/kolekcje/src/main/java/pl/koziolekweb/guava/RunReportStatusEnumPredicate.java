package pl.koziolekweb.guava;

import com.google.common.base.Predicate;
import pl.koziolekweb.guava.domain.RunReportStatusEnum;

import static pl.koziolekweb.guava.domain.RunReportStatusEnum.CANCELED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.COMPLETED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.FAILED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.QUEUED;
import static pl.koziolekweb.guava.domain.RunReportStatusEnum.RUNNING;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public enum RunReportStatusEnumPredicate implements Predicate<String> {
	IS_QUEUED(QUEUED),
	IS_RUNNING(RUNNING),
	IS_COMPLETED(COMPLETED),
	IS_FAILED(FAILED),
	IS_CANCELED(CANCELED);
	private final RunReportStatusEnum statusEnum;

	private RunReportStatusEnumPredicate(RunReportStatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}

	@Override
	public boolean apply(String input) {
		return statusEnum.getStatusText().equals(input);
	}
}
