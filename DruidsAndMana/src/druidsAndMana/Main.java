package druidsAndMana;

public class Main {

	
	public static void main(String[] args) {
		
		ConsoleInputService input = new ConsoleInputService();
		GameAdmin admin = new GameAdmin(input);
		
		GameBoard board = admin.createGameBoard();
		admin.numOfPlayers();
		System.out.println(admin.checkIfSquareIsOwned(board, 2));
		System.out.println(board.squareIsGrassland(2));
		System.out.println(board.costToUpgrade("1", 2));
	}
}
