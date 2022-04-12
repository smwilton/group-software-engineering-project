package druidsAndMana;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		ConsoleInputService input = new ConsoleInputService();
		GameAdmin admin = new GameAdmin(input);
		
		admin.playerSetUp(admin.numOfPlayers());
		admin.createGameBoard();
		System.out.println("\n\n\nUp first is "+admin.getCurrentPlayer().getPlayerName());
		for (Player player : admin.players) {
			System.out.println(player.toString());
		}
		int roll=admin.roll();
		admin.movePlayer(roll);
		admin.displaySquareDetails();
		admin.buyUnownedGrassland(admin.board, roll, 1);
		System.out.println("\n\n\n" +admin.isSquareOwned(admin.board, roll));
		System.out.println(admin.board.getCO2Modifier(roll));
		int owner = admin.board.getSquareOwnerId(roll);
		System.out.println(admin.players.get(owner-1).toString()+"\n\n");
		admin.endTurn();
		roll=admin.roll();
		admin.movePlayer(roll);
		admin.displaySquareDetails();
		for (Player player : admin.players) {
			System.out.println(player.toString());
		}
	}
}
