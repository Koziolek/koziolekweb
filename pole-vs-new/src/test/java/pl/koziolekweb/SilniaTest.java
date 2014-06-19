package pl.koziolekweb;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.assertThat;

public class SilniaTest {

	private Silnia silnia;

	@BeforeMethod
	public void setUp() throws Exception {
		this.silnia = new Silnia();
	}

	@Test
	public void shouldSilnia0Return1() throws Exception {
		assertThat(silnia.oblicz(BigInteger.ZERO)).isEqualTo(BigInteger.ONE);
	}

	@Test
	public void shouldSilnia1Return1() {
		assertThat(silnia.oblicz(BigInteger.ONE)).isEqualTo(BigInteger.ONE);
	}

	@Test
	public void shouldSilnia12Return479001600() {
		assertThat(silnia.oblicz(new BigInteger("12"))).isEqualTo(new BigInteger("479001600"));
	}

	@Test
	public void shouldSilnia50ReturnReallyBigNumber() {
		assertThat(silnia.oblicz(new BigInteger("50"))).isEqualTo(new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"));
	}
	@Test
	public void iDontBeliveItsFast() {
		silnia.oblicz(new BigInteger("1000"));
	}
}

