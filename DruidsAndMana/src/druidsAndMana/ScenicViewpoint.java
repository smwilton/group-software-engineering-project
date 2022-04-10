package druidsAndMana;

/**
 * @author Peter McCullough 40055438
 *
 */
public class ScenicViewpoint implements ISquare {

	public int getChargeForLandingOnSquare() {
		return 0;
	}

	@Override
	public String description() {
		return "The scenic viewpoint represents a safe place for the druids to stop. There are no consequences for landing on this square";
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
