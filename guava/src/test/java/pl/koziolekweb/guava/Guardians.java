package pl.koziolekweb.guava;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Guardians {

	public int attackMod(UnitType type, int numberOf) {
		checkArgument(numberOf >= 0);
		switch (type) {
			case Marine:
				return 2 * numberOf;
				break;
			case Ork:
				if (numberOf >= 20) {
					return (int) (1.5 * numberOf * quarrel());
				}
				return (int) (1.3 * numberOf);
			break;
			case Human:
				return 1 * numberOf;
				break;
		}
	}

	private int quarrel() {
		return Math.random() > 0.1 ? 1 : 0;
	}
}

enum UnitType {
	Marine, Ork, Human
}