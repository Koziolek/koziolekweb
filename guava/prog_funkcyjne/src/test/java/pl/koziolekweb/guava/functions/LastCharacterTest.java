package pl.koziolekweb.guava.functions;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static pl.koziolekweb.guava.functions.LastCharacter.lastCharacter;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 30.12.13
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
public class LastCharacterTest {

	@Test
	public void testApplyForString() throws Exception {
		assertThat(lastCharacter("Ala")).isEqualTo('a');
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testApplyForNull() throws Exception {
		lastCharacter(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testApplyForEmpty() throws Exception {
		lastCharacter("");
	}

}
