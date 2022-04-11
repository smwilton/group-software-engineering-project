package druidsAndMana;
/**
 * Class that extends Grassland and represents a TIER_1 Grassland object
 *
 * @author Nicola Stirling 40020701
 *
 */
public class Tropical extends Grassland {

	public Tropical(RealmTier realm) {
		super(realm);
	}

	@Override
	public String description() {
		return "The tropical grassland has a bustling and diverse ecosystem where each player will find harmony with Nature";
	}
	
	@Override
	public String asciiArt() {
		return "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
			+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
	}
}
