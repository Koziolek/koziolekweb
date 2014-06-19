package pl.koziolekweb;

import com.google.common.collect.Collections2;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class FunctionLambdaInline {

	public Collection<BigInteger> obliczSilnie(List<BigInteger> input) {

		return Collections2.transform(input, n -> App.silnia.oblicz(n));
	}
}
