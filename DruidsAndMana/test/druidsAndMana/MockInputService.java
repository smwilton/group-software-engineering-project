package druidsAndMana;

public class MockInputService implements IInputService {

	// This is a test fixture without using a mocking software like MOQ etc.
	private String userInputResponse;
	private int userIntInputResponse;
	private boolean confirmation = false;
	private String[] responses = new String[5];
	private String[] fewerResponses = new String[2];
	private int arrayIteration = 0;

	public boolean getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public void setUserInputResponse4PlayerArray(String response1, String response2, String response3, String response4,
			String response5) {
		responses[0] = response1;
		responses[1] = response2;
		responses[2] = response3;
		responses[3] = response4;
		responses[4] = response5;
		setUserInputResponse(response1);
	}

	public void printResponsesArray() {
		for (String response : responses) {
			System.out.println(response);
		}
	}

	public void printFewerResponsesArray() {
		for (String response : fewerResponses) {
			System.out.println(response);
		}
	}

	public void setUserInputResponse1PlayerArray(String response1, String response2) {
		fewerResponses[0] = response1;
		fewerResponses[1] = response2;
		setUserInputResponse(response1);
	}

	public String getUserInputResponse() {
		return this.userInputResponse;
	}

	public void setUserInputResponse(String response) {
		this.userInputResponse = response;
	}

	public void setUserIntInput(int response) {
		this.userIntInputResponse = response;
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
		if (arrayIteration < 4) {
			arrayIteration++;
		} else {
			arrayIteration = 0;
		}
		if (fewerResponses[0] == null) {
			setUserInputResponse(responses[arrayIteration]);
		} else {
			setUserInputResponse(fewerResponses[arrayIteration]);
		}
		return userInputResponse;
	}

	
	@Override
	public int GetUserIntInput(String prompt, int[] allowedInputs) {
		
		return userIntInputResponse;
	}

}