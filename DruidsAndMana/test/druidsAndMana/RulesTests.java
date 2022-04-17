package druidsAndMana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RulesTests {

	private Rules rules;
	
	@BeforeEach
	void setUp() throws Exception {
		rules = new Rules(null);
	}
	@Test
	void testDisplayRules() {
		String displayRules = rules.displayRules();
		assertTrue(displayRules.contains("Game"));
		assertTrue(displayRules.contains("Grassland with 2 forests"));
		assertTrue(displayRules.contains("The game has 2 to 4 druids"));
		
	}

}
