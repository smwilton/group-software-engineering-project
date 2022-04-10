/**
 * 
 */
package druidsAndMana;

/**
 * @author Nicola
 *
 */
public class ScenicViewpoint implements ISquare{

	public int manaCharge() {
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
