package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Player Class
 * 
 * @author Nicola
 *
 */
class PlayerTests {

	Player player;
	String playerName;
	int playerNumber, playerPosition, mana, co2, roll;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		playerName = "Jill";
		playerNumber = 2;
		playerPosition = 12;
		mana = 100;
		co2 = 1150;
		roll = 8;
		player = new Player("Jack", 4, 10, 1000, 50, 5);
	}

	/**
	 * Test method for
	 * {@link druidsAndMana.Player#Player(java.lang.String, int, int, int, int, int)}.
	 * 
	 * Tests the constructor sets all the expected balances.
	 */
	@Test
	void testPlayer() {
		Player testPlayer = new Player("Jack", 4, 10, 1000, 50, 5);
		assertTrue(testPlayer instanceof Player);
		assertTrue(testPlayer.isActive());
		assertEquals("Jack", testPlayer.getPlayerName());
		assertEquals(4, testPlayer.getPlayerNumber());
		assertEquals(10, testPlayer.getPlayerPosition());
		assertEquals(1000, testPlayer.getMana());
		assertEquals(50, testPlayer.getCo2());
		assertEquals(5, testPlayer.getRoll());
	}

	/**
	 * Test method for {@link druidsAndMana.Player#getRoll()} and
	 * {@link druidsAndMana.Player#setRoll(int)}.
	 */
	@Test
	void testGetSetRoll() {
		player.setRoll(roll);
		assertEquals(roll, player.getRoll());
	}

	/**
	 * Test method for {@link druidsAndMana.Player#getPlayerName()} and
	 * {@link druidsAndMana.Player#setPlayerName(java.lang.String)}.
	 */
	@Test
	void testGetSetPlayerName() {
		player.setPlayerName(playerName);
		assertEquals(playerName,player.getPlayerName());
	}

	/**
	 * Test method for {@link druidsAndMana.Player#getPlayerNumber()} and
	 * {@link druidsAndMana.Player#setPlayerNumber(int)}.
	 */
	@Test
	void testGetSetPlayerNumber() {
		player.setPlayerNumber(playerNumber);
		assertEquals(playerNumber,player.getPlayerNumber());
	}

	/**
	 * Test method for {@link druidsAndMana.Player#getPlayerPosition()} and
	 * {@link druidsAndMana.Player#setPlayerPosition(int)}.
	 */
	@Test
	void testGetSetPlayerPosition() {
		player.setPlayerPosition(playerPosition);
		assertEquals(playerPosition,player.getPlayerPosition());
	}

	/**
	 * 
	 * 
	 * /** Test method for {@link druidsAndMana.Player#getMana()} and
	 * {@link druidsAndMana.Player#setMana(int)}.
	 */
	@Test
	void testGetSetMana() {
		player.setMana(mana);
		assertEquals(mana,player.getMana());
	}

	/**
	 * Test method for {@link druidsAndMana.Player#getCo2()} and
	 * {@link druidsAndMana.Player#setCo2(int)}.
	 */
	@Test
	void testGetSetCo2() {
		player.setCo2(co2);
		assertEquals(co2,player.getCo2());
	}

	/**
	 * Test method for {@link druidsAndMana.Player#isActive()} and
	 * {@link druidsAndMana.Player#setIsActive(boolean)}.
	 */
	@Test
	void testIsActiveSetIsActive() {
		player.setIsActive(false);
		assertFalse(player.isActive());
	}


	/**
	 * Test method for {@link druidsAndMana.Player#toString()}.
	 */
	@Test
	void testToString() {
		String expected = "Player [playerName=Jack, mana=1000, co2=50, playerNumber=4, playerPosition=10]";
		assertEquals(expected, player.toString());
	}

}
