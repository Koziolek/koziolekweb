package pl.koziolekweb.guava;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.net.InternetDomainName;

import java.util.HashMap;

import static com.google.common.base.Joiner.on;
import static com.google.common.net.InternetDomainName.from;
import static com.google.common.net.InternetDomainName.isValid;
import static pl.koziolekweb.guava.BooleanMap.equalNotEqual;
import static pl.koziolekweb.guava.BooleanMap.validInvalid;
import static pl.koziolekweb.guava.BooleanMap.yesNo;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class InternetDomainNamesBasics {

	public static final String KOZIOLEKWEB_PL = "koziolekweb.pl";
	public static final InternetDomainName KOZIOLEKWEB_PL_IDN = from(KOZIOLEKWEB_PL);

	public static final String APPSPOT_COM = "appspot.com";
	public static final InternetDomainName APPSPOT_COM_IDN = from(APPSPOT_COM);

	public static final String TYRSOFT_PL = "tyrsoft.com";
	public static final InternetDomainName TYRSOFT_PL_IDN = from(TYRSOFT_PL);

	public static final String ETH = "8thcolour";
	public static final String ETH_TYRSOFT_PL = "8thcolour.tyrsoft.com";
	public static final InternetDomainName ETH_TYRSOFT_PL_IDN = from(ETH_TYRSOFT_PL);


	public static void main(String[] args) {
		isValidExample();
		childExample();
		parentExample();
		hasParentExample();
		hasPublicSuffixExample();
		isPublicSuffixExample();
		isTopPrivateExample();
		isUnderPublicSuffixExample();
		partsExample();
		publicSuffixExample();
		topPrivateDomainExample();
	}

	public static void isValidExample() {
		System.out.printf("Domain %s is %s\n", KOZIOLEKWEB_PL, validInvalid(isValid(KOZIOLEKWEB_PL)));
		System.out.printf("Domain %s is %s\n", "Koziołekłeb.pl", validInvalid(isValid("Koziołekłeb.pl")));
		System.out.printf("Domain %s is %s\n", "$#%$##.com", validInvalid(isValid("$#%$##.com")));
	}

	public static void childExample() {
		InternetDomainName child = TYRSOFT_PL_IDN.child(ETH);
		System.out.printf("Domain %s has child %s and it is %s to %s\n", TYRSOFT_PL, child,
				equalNotEqual(child.equals(ETH_TYRSOFT_PL_IDN)),
				ETH_TYRSOFT_PL);

	}

	public static void parentExample() {
		InternetDomainName parent = ETH_TYRSOFT_PL_IDN.parent();
		System.out.printf("Parent of %s is %s and is %s to %s\n", ETH_TYRSOFT_PL, parent
				, equalNotEqual(parent.equals(TYRSOFT_PL_IDN)), TYRSOFT_PL);

		System.out.printf("Parent of %s is %s\n", TYRSOFT_PL, TYRSOFT_PL_IDN.parent());

	}

	public static void hasParentExample() {
		System.out.printf("Is domain %s has parent? %s\n", TYRSOFT_PL, yesNo(TYRSOFT_PL_IDN.hasParent()));
	}

	public static void hasPublicSuffixExample() {
		System.out.printf("Has domain %s public suffix? %s\n", TYRSOFT_PL, yesNo(TYRSOFT_PL_IDN.hasPublicSuffix()));
		System.out.printf("Has domain %s public suffix? %s\n", ETH_TYRSOFT_PL, yesNo(ETH_TYRSOFT_PL_IDN.hasPublicSuffix()));
	}

	public static void isPublicSuffixExample() {
		System.out.printf("Is domain %s public suffix? %s\n", TYRSOFT_PL, yesNo(TYRSOFT_PL_IDN.isPublicSuffix()));
		System.out.printf("Is domain %s public suffix? %s\n", APPSPOT_COM, yesNo(APPSPOT_COM_IDN.isPublicSuffix()));
	}

	public static void isTopPrivateExample() {
		System.out.printf("Is domain %s TPD? %s\n", TYRSOFT_PL, yesNo(TYRSOFT_PL_IDN.isTopPrivateDomain()));
		System.out.printf("Is domain %s TPD? %s\n", ETH_TYRSOFT_PL, yesNo(ETH_TYRSOFT_PL_IDN.isTopPrivateDomain()));
		System.out.printf("Is domain %s TPD? %s\n", APPSPOT_COM, yesNo(APPSPOT_COM_IDN.isTopPrivateDomain()));
	}

	public static void isUnderPublicSuffixExample() {
		System.out.printf("Is domain %s under public suffix? %s\n", ETH_TYRSOFT_PL, yesNo(ETH_TYRSOFT_PL_IDN.isUnderPublicSuffix()));
		System.out.printf("Is domain %s under public suffix? %s\n", APPSPOT_COM, yesNo(APPSPOT_COM_IDN.isUnderPublicSuffix()));
	}

	public static void partsExample() {
		System.out.printf("Domain %s parts: %s\n", ETH_TYRSOFT_PL, on(", ").join(ETH_TYRSOFT_PL_IDN.parts()));
	}
	public static void publicSuffixExample() {
		System.out.printf("Domain %s public suffix is %s\n", ETH_TYRSOFT_PL, ETH_TYRSOFT_PL_IDN.publicSuffix());
	}
	public static void topPrivateDomainExample() {
		System.out.printf("TPD of %s is %s\n", ETH_TYRSOFT_PL, ETH_TYRSOFT_PL_IDN.topPrivateDomain());
	}

}


