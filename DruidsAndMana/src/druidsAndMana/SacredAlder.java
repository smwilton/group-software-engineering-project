package druidsAndMana;

/**
 * @author Peter McCullough 40055438
 *
 */
public class SacredAlder implements ISquare {

	@Override
	public int getChargeForLandingOnSquare() {
		return -200; // Player receives 200 mana points for landing on this square:
	}

	@Override
	public String description() {
		return "The Sacred Alder square is the birthplace of all druids";
	}

	@Override
	public String asciiArt() {

		return "              v .   ._, |_  .,\r\n" 
				+ "           `-._\\/  .  \\ /    |/_\r\n"
				+ "               \\\\  _\\, y | \\//\r\n" 
				+ "         _\\_.___\\\\, \\\\/ -.\\||\r\n"
				+ "           `7-,--.`._||  / / ,\r\n" 
				+ "           /'     `-. `./ / |/_.'\r\n"
				+ "                     |    |//\r\n" 
				+ "                     |_    /\r\n"
				+ "                     |-   |\r\n" 
				+ "                     |   =|\r\n"
				+ "                     |    |\r\n" 
				+ "--------------------/ ,  . \\--------._";
	}
}
