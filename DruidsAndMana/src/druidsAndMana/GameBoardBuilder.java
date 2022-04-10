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
		squares[1] = new Tropical(Realm.Tropical);
		squares[2] = new Tropical(Realm.Tropical);
		
		// Create three sub-tropical squares:
		squares[3] = new Subtropical(Realm.Subtropical);
		squares[4] = new Subtropical(Realm.Subtropical);
		squares[5] = new Subtropical(Realm.Subtropical);
		
		// Add the Scenic viewpoint:
		squares[6] = new ScenicViewpoint();
		
		// Add the temperate squares:
		squares[7] = new Temperate(Realm.Temperate);
		squares[8] = new Temperate(Realm.Temperate);
		squares[9] = new Temperate(Realm.Temperate);
		
		// Add the boreal squares:
		squares[10] = new Boreal(Realm.Boreal);
		squares[11] = new Boreal(Realm.Boreal);

		return squares;
	}
}
