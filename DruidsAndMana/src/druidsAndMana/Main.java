package druidsAndMana;

public class Main {
	
	public static void main(String[] args) {
		IInputService inputService = new ConsoleInputService();
		IOutputService outputService = new ConsoleOutputService();
		GameEngine gameEngine = new GameEngine(inputService, outputService);
		gameEngine.startGameEngine();
	}
}
