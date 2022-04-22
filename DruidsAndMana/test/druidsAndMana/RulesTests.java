package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RulesTests {

	private Rules rules;
	
	@BeforeEach
	void setUp() throws Exception {
		rules = new Rules();
	}
	@Test
	void testDisplayRules() {
		String displayRules = rules.displayRules();
		assertTrue(displayRules.contains("Game"));
		assertTrue(displayRules.contains("Grassland within a Realm"));
		assertTrue(displayRules.contains("The game has 2 to 4 druids"));
		assertTrue(displayRules.contains("Once a Druid has planted 3 forests on their grassland they can implement an upgrade"));
		
	}

}
