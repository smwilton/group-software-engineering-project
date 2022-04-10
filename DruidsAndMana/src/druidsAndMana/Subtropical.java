package druidsAndMana;

public class Subtropical extends GrasslandBase {
	public Subtropical(GrasslandValues grasslandValues) {
		super(grasslandValues);
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
