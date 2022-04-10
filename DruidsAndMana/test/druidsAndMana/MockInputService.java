package druidsAndMana;

import druidsAndMana.IInputService;

public class MockInputService implements IInputService {

	//This is a test fixture without using a mocking software like MOQ etc.
	private String userInputResponse;
	
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String GetOpenUserInput(String prompt) {
		// TODO Auto-generated method stub
		return null;
	}

}