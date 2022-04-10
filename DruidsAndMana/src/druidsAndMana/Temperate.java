package druidsAndMana;

public class Temperate extends GrasslandBase{

	public Temperate(GrasslandValues grasslandValues) {
		super(grasslandValues);
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
