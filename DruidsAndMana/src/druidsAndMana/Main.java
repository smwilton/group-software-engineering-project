package druidsAndMana;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		// Creating Services:
		ConsoleInputService inputService = new ConsoleInputService();
		ConsoleOutputService outputService = new ConsoleOutputService();
		IGameBoardBuilder gameBoardBuilder = new GameBoardBuilder();
		IGameBoard gameBoard = new GameBoard(gameBoardBuilder);
		
		GameAdmin admin = new GameAdmin(inputService, outputService, gameBoard);
		Menu menu = new Menu(admin, inputService, outputService);
		
		menu.displayMenu();
		
		
		
		
		
		
		
		
		
		/**
		admin.playerSetUp(admin.numOfPlayers());		
		System.out.println("\n\n\nUp first is "+admin.getCurrentPlayer().getPlayerName());
		System.out.println(admin.getCurrentPlayer().toString());
		for (Player player : admin.players) {
			System.out.println(player.toString());
		}
		int roll=admin.roll();
		admin.movePlayer(roll);
		System.out.println(admin.getCurrentPlayer().toString());
		admin.displaySquareDetails();
		admin.buyUnownedGrassland(roll, 1);
		System.out.println("\n\n\n" +admin.isSquareOwned(roll));
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
		for (Player player : admin.players) {
			System.out.println(player.toString()+"\n");
		}
		admin.declareWinner();
		**/
	}
}
