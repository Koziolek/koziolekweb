package pl.koziolekweb.guava;

import static pl.koziolekweb.guava.functions.GetSexFromName.getSexFromName;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 31.12.13
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class FunctionsAndPredicatesCompositionExample {

	public static void main(String[] args) {
		System.out.println(getSexFromName("Ala"));
		System.out.println(getSexFromName("Jaś"));
	}
}




