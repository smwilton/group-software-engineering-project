package druidsAndMana;
/**
 * Class that extends Grassland and represents a TIER_3 Grassland object
 *
 * @author Nicola Stirling 40020701
 *
 */
public class Temperate extends Grassland{

	public Temperate(RealmTier realm) {
		super(realm);
	}

	@Override
	public String description() {
		return "Temporate grasslands experience heavy rainfall but also periods of drought, giving a highly diverse ecosystem";
	}
	
	@Override
	public String asciiArt() {
		return "^   ^   ^    ^         ___I_    ^   ^    ^   ^   ^    ^   ^\r\n"
			+ "/|\\/|\\/|\\ /|\\    /\\-_--\\  /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   /  \\_-__\\ /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n"
			+ "/|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\";
	}
}
