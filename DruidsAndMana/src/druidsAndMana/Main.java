package druidsAndMana;

public class Main {

	
	public static void main(String[] args) {
		
		ConsoleInputService input = new ConsoleInputService();
		GameAdmin admin = new GameAdmin(input);
		System.out.println(admin.players.size());
		/**
		GameBoard board = admin.createGameBoard();
		admin.playerSetUp(admin.numOfPlayers());
		System.out.println(admin.checkIfSquareIsOwned(board, 2) + "\n");
		System.out.println(board.squareIsGrassland(2) + "\n");
		System.out.println(board.costToUpgrade("1", 2) + "\n");
		for (Player player : admin.players) {
			System.out.println(player.toString());
		}
		**/
	}
}
