package pl.koziolekweb.guava.optional;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class OptionalExamplesTest {


	OptionalExamples oe = new OptionalExamples();

	@Test
	public void testAddToMap() throws Exception {
		oe.addToMap("Key", null);
		oe.addToMap(null, null);
		assertThat(oe.getMap()).hasSize(2);
		assertThat(oe.getMap()).entry("null", null);

	}

	@Test
	public void testForceNPE() throws Exception {
		assertThat(oe.forceNPE(5)).isEqualTo(5);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testForceNPEThrowNPE() {
		assertThat(oe.forceNPE(null)).isEqualTo(5);
	}

	@Test
	public void testSupressNPE() throws Exception {
		assertThat(oe.supressNPE(5)).isEqualTo(5);
		assertThat(oe.supressNPE(null)).isEqualTo(OptionalExamples.DEFAULT_INT);
	}
}
