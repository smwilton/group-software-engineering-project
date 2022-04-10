package druidsAndMana;

import druidsAndMana.IInputService;

public class MockInputService implements IInputService {

	//This is a test fixture without using a mocking software like MOQ etc.
	private String userInputResponse;
	private boolean confirmation = false;
	
	
	
	public boolean getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public String getUserInputResponse(){
		return this.userInputResponse;
	}
	
	public void setUserInputResponse(String response) {
		this.userInputResponse = response;
	}
	
	@Override
	public String GetUserInput(String prompt, String[] allowedInputs) {
		
		return userInputResponse;
	}

	@Override
	public boolean GetUserConfirmation(String prompt) {
		
		return confirmation;
	}

	@Override
	public String GetOpenUserInput(String prompt) {
		
		return userInputResponse;
	}

}