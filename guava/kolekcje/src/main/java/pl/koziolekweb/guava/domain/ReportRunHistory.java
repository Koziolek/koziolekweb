package pl.koziolekweb.guava.domain;

import java.util.Map;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class ReportRunHistory {

	public final int raportRunId;

	public final String  status;

	public final Map<String, Object> params;

	public ReportRunHistory(int raportRunId, String status, Map<String, Object> params) {
		this.raportRunId = raportRunId;
		this.status = status;
		this.params = params;
	}

	@Override
	public String toString() {
		return "ReportRunHistory{" +
				"raportRunId=" + raportRunId +
				", status=" + status +
				", params=" + params +
				'}';
	}
}
