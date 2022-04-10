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
		squares[1] = new Tropical(new GrasslandValues(Realm.TROPICAL));
		squares[2] = new Tropical(new GrasslandValues(Realm.TROPICAL));
		
		// Create three sub-tropical squares:
		squares[3] = new Subtropical(new GrasslandValues(Realm.SUBTROPICAL));
		squares[4] = new Subtropical(new GrasslandValues(Realm.SUBTROPICAL));
		squares[5] = new Subtropical(new GrasslandValues(Realm.SUBTROPICAL));
		
		// Add the Scenic viewpoint:
		squares[6] = new ScenicViewpoint();
		
		// Add the temperate squares:
		squares[7] = new Temperate(new GrasslandValues(Realm.TEMPERATE));
		squares[8] = new Temperate(new GrasslandValues(Realm.TEMPERATE));
		squares[9] = new Temperate(new GrasslandValues(Realm.TEMPERATE));
		
		// Add the boreal squares:
		squares[10] = new Boreal(new GrasslandValues(Realm.BOREAL));
		squares[11] = new Boreal(new GrasslandValues(Realm.BOREAL));

		return squares;
	}
}
