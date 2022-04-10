package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameAdminTests {
	
	String name1, name2, duplicateName;
	int numOfPlayersAllowed, numOfPlayersNotAllowed;
	GameAdmin gameAdmin;
	MockInputService inputService;
	
	@BeforeEach
	void setUp() throws Exception{
		name1 = "Tester";
		name2 = "Tester2";
		duplicateName = "Tester";
		numOfPlayersAllowed=2;
		numOfPlayersNotAllowed=6;
		gameAdmin = new GameAdmin(inputService);
	}
	

	@Test
	void testGameAdmin() {
		fail("Not yet implemented");
	}

	@Test
	void testNumOfPlayers() {
		fail("Not yet implemented");
	}

	@Test
	void testPlayerSetUp() {
		fail("Not yet implemented");
	}

}
