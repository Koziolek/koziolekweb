package pl.koziolekweb.guava.domain;

import java.util.Map;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class ReportRequestRun {

	final int raportRunId;

	final Map<String, Object> params;

	public ReportRequestRun(int raportRunId, Map<String, Object> params) {
		this.raportRunId = raportRunId;
		this.params = params;
	}
}
