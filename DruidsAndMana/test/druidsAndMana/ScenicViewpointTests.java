/**
 * 
 */
package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Nicola
 *
 */
class ScenicViewpointTests {

	ISquare square;
	int expectedCharge;
	String expectedDescription, expectedAsciiArt;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		square = new ScenicViewpoint();
		expectedCharge = 0;
		expectedDescription = "The scenic viewpoint represents a safe place for the druids to stop. There are no consequences for landing on this square.\n"
				+ "So take a seat and gaze upon the landscape as the druids replenish it's splendour!";
		expectedAsciiArt = " .    '                   .  \"   '\r\n" 
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

	/**
	 * Test method for {@link druidsAndMana.ScenicViewpoint#getChargeForLandingOnSquare()}.
	 */
	@Test
	void testGetChargeForLandingOnSquare() {
		assertEquals(expectedCharge, square.getChargeForLandingOnSquare());
	}

	/**
	 * Test method for {@link druidsAndMana.ScenicViewpoint#description()}.
	 */
	@Test
	void testDescription() {
		assertEquals(expectedDescription, square.description());
	}

	/**
	 * Test method for {@link druidsAndMana.ScenicViewpoint#asciiArt()}.
	 */
	@Test
	void testAsciiArt() {
		assertEquals(expectedAsciiArt, square.asciiArt());
	}

}
