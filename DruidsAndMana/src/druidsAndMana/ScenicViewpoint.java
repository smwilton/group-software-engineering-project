package druidsAndMana;

/**
 * @author pete
 *
 */
public class ScenicViewpoint implements ISquare {

	public int getChargeForLandingOnSquare() {
		return 0;
	}

	@Override
	public String description() {
		return "The scenic viewpoint represents a safe place for the druids to stop. There are no consequences for landing on this square.\n"
				+ "So take a seat and gaze upon the landscape as the druids replenish it's splendour!";
	}

	@Override
	public String asciiArt() {
		return " .    '                   .  \"   '\r\n" 
				+ "            .  .  .                 '      '\r\n"
				+ "    \"`       .   .\r\n" 
				+ "                                     '     '\r\n"
				+ "  .    '      _______________\r\n" 
				+ "          ==c(___(o(______(_()\r\n"
				+ "                  \\=\\\r\n" 
				+ "                   )=\\\r\n" 
				+ "                  //|\\\\\r\n"
				+ "                 //|| \\\\\r\n" 
				+ "                // ||  \\\\\r\n"
				+ "               //  ||   \\\\\r\n" 
				+ "              //         \\\\";
	}
}
