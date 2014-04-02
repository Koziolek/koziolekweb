package pl.koziolekweb.java8.date;

import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class DurationPeriodInterval {

	@Test
	public void durations() {
		Duration duration = Duration.of(10, ChronoUnit.NANOS);
		Duration plus10s = duration.plus(10, ChronoUnit.SECONDS);
	}

	@Test
	public void periods() {
		Period period = Period.of(1, 1, 1);
		Period plus10Days = period.plusDays(10);
	}

	public void intervals() {
		Instant instant = Instant.now(); // tu i teraz
	}
}
