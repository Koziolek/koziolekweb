package pl.koziolekweb.java8.date;

import org.testng.annotations.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class DateAndTimeBasics {

	@Test
	public void clock() {
		Clock defaultZone = Clock.systemDefaultZone();
		System.err.println(defaultZone);

		Clock plus2 = Clock.offset(defaultZone, Duration.ofDays(2));
		System.err.println(plus2);
	}

	@Test
	public void localDate() {
		LocalDate now = LocalDate.now();
		System.err.printf("%s-%s-%s\n", now.getDayOfMonth(), now.getMonth(), now.getYear());

		LocalDate localDate = LocalDate.of(2014, 03, 17);
		System.err.printf("%s-%s-%s\n", localDate.getDayOfMonth(), localDate.getMonth(), localDate.getYear());

		Date date = new Date(2014, 03, 17);
		System.err.printf("%s-%s-%s\n", date.getDate(), date.getMonth(), date.getYear());

	}

	@Test
	public void localTime() {
		LocalTime localTime = LocalTime.now();
		System.err.printf("%s:%s\n", localTime.getHour(), localTime.getMinute());
		LocalTime plus5h = localTime.plusHours(5);
		System.err.printf("%s:%s\n", plus5h.getHour(), plus5h.getMinute());

	}
}
