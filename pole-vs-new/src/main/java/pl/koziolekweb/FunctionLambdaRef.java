package pl.koziolekweb;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class FunctionLambdaRef {

	public Collection<BigInteger> obliczSilnie(List<BigInteger> input) {

		return Collections2.transform(input, App.silnia::oblicz);
	}
}
