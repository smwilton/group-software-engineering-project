package druidsAndMana;

public class GameBoardBuilder implements IGameBoardBuilder {
	
	public ISquare[] buildGameBoard() {
		
		final int noSquares = 12;
		
		ISquare[] squares = new ISquare[noSquares];
		
		// Add the sacred elder square:
		squares[0] = new SacredAlder();
		
		// Create the GrasslandValues instance to pass into the grasslands
		// This injects all the information about costs, decoupling it from the classes
		// This allows for a loosely coupled application
		
		// Create two tropical squares:
		squares[1] = new Tropical(RealmTier.TIER_1);
		squares[2] = new Tropical(RealmTier.TIER_1);
		
		// Create three sub-tropical squares:
		squares[3] = new Subtropical(RealmTier.TIER_2);
		squares[4] = new Subtropical(RealmTier.TIER_2);
		squares[5] = new Subtropical(RealmTier.TIER_2);
		
		// Add the Scenic viewpoint:
		squares[6] = new ScenicViewpoint();
		
		// Add the temperate squares:
		squares[7] = new Temperate(RealmTier.TIER_3);
		squares[8] = new Temperate(RealmTier.TIER_3);
		squares[9] = new Temperate(RealmTier.TIER_3);
		
		// Add the boreal squares:
		squares[10] = new Boreal(RealmTier.TIER_4);
		squares[11] = new Boreal(RealmTier.TIER_4);

		return squares;
	}
}
