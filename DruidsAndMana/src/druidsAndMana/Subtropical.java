package druidsAndMana;
/**
 * Class that extends Grassland and represents a Subtropical Grassland object
 *
 * @author Nicola Stirling 40020701
 *
 */
public class Subtropical extends Grassland {
	public Subtropical(Realm realm) {
		super(realm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String description() {
		return "The sub-tropical grasslands have a warm and humid climate, with cooler winters";
	}

	@Override
	public String asciiArt() {
		return "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
			+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
	}
}
