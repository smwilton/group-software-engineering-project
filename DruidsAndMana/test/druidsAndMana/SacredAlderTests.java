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
class SacredAlderTests {
	
	ISquare square;
	int expectedCharge;
	String expectedDescription, expectedAsciiArt;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		square = new SacredAlder();
		expectedCharge = 0;
		expectedDescription = "The Sacred Alder square is the birthplace of all druids";
		expectedAsciiArt = "              v .   ._, |_  .,\r\n" 
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

	/**
	 * Test method for {@link druidsAndMana.SacredAlder#getChargeForLandingOnSquare()}.
	 */
	@Test
	void testGetChargeForLandingOnSquare() {
		assertEquals(expectedCharge, square.getChargeForLandingOnSquare());
	}

	/**
	 * Test method for {@link druidsAndMana.SacredAlder#description()}.
	 */
	@Test
	void testDescription() {
		assertEquals(expectedDescription, square.description());
	}

	/**
	 * Test method for {@link druidsAndMana.SacredAlder#asciiArt()}.
	 */
	@Test
	void testAsciiArt() {
		assertEquals(expectedAsciiArt, square.asciiArt());
	}

}
