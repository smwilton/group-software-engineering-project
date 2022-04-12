package druidsAndMana;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		ConsoleInputService input = new ConsoleInputService();
		GameAdmin admin = new GameAdmin(input);
		
		admin.playerSetUp(admin.numOfPlayers());
		admin.createGameBoard();
		System.out.println(admin.isSquareOwned(admin.board, 4) + "\n");
		System.out.println(admin.board.squareIsGrassland(4) + "\n");
		System.out.println(admin.board.costToUpgrade(4) + "\n");
		for (Player player : admin.players) {
			System.out.println(player.toString());
		}
		admin.movePlayer(4);
		admin.displaySquareDetails();
		admin.buyUnownedGrassland(admin.board, 4, 1);
		System.out.println("\n\n\n" +admin.isSquareOwned(admin.board, 4));
		int owner = admin.board.getSquareOwnerId(4);
		System.out.println(admin.players.get(owner-1).toString());
	}
}
