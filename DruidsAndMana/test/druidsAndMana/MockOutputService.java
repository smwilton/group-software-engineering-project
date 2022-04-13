package druidsAndMana;

/**
 * 
 * @author pete
 *
 */

public class MockOutputService implements IOutputService {

	private String lastOutput;
	private String allOutput = "";
	
	public String getLastOutput() {
		return lastOutput;
	}
	
	public String getAllOutput() {
		return allOutput;
	}

	@Override
	public void println(String text) {
		this.lastOutput = text;
		this.allOutput += text;
	}

	@Override
	public void print(String text) {
		this.lastOutput = text;
		this.allOutput += text;
	}

}
