package pl.koziolekweb;

import java.math.BigInteger;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Silnia {

	public BigInteger oblicz(BigInteger n) {
		return tailRec(BigInteger.ONE, n);
	}


	private BigInteger tailRec(BigInteger acc, BigInteger n) {
		if (n.equals(BigInteger.ZERO))
			return acc;
		return tailRec(acc.multiply(n), n.subtract(BigInteger.ONE));
	}

}
