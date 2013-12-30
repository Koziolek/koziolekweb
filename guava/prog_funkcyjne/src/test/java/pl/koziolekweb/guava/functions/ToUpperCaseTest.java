package pl.koziolekweb.guava.functions;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static pl.koziolekweb.guava.functions.ToUpperCase.toUpperCase;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 30.12.13
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public class ToUpperCaseTest {


	@Test
	public void testApplyForString() throws Exception {
		assertThat(toUpperCase("ala")).isEqualTo("ALA");
	}

	@Test
	public void testApplyForNull() throws Exception {
		assertThat(toUpperCase(null)).isNull();
	}
}
