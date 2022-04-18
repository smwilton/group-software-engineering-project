package druidsAndMana;

public class Main {
	
	public static void main(String[] args) throws Exception {
		IInputService inputService = new ConsoleInputService();
		IOutputService outputService = new ConsoleOutputService();
		IGameBoardBuilder builder = new GameBoardBuilder();
		GameBoard board = new GameBoard(builder);
		GameAdmin admin = new GameAdmin(inputService, outputService, board);
		Menu menu = new Menu(admin, inputService, outputService);
		GameEngine gameEngine = new GameEngine(inputService, outputService, menu);
		
		gameEngine.startGameEngine();
	}
}
