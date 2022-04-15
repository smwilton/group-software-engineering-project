package druidsAndMana;

/**
 * 
 * @author pete
 *
 */

public class ConsoleOutputService implements IOutputService {

	@Override
	public void println(String text) {
		System.out.println(text);
	}
	
	@Override
	public void print(String text) {
		System.out.print(text);
	}
}
