package pl.koziolekweb.guava.domain;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public enum RunReportStatusEnum {

	QUEUED("queued"), RUNNING("running"), COMPLETED("completed"), FAILED("failed"), CANCELED("canceled");

	private final String statusText;

	private RunReportStatusEnum(String statusText) {
		this.statusText = statusText;
	}

	public String getStatusText() {
		return statusText;
	}

}
