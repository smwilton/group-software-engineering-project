package druidsAndMana;

/**
 * @author Sandra
 *
 */
public class Player {

	private String playerName;
	private int mana;
	private int co2;
	private int roll;
	private int playerNumber;
	private int playerPosition;
	private boolean isActive;

	/**
	 * Constructor with args
	 * 
	 * @param playerName
	 * @param playerNumber
	 * @param playerPosition
	 * @param mana
	 * @param co2
	 * @param roll
	 */
	public Player(String playerName, int playerNumber, int playerPosition, int mana, int co2, int roll) {
		this.setPlayerName(playerName);
		this.setPlayerNumber(playerNumber);
		this.setPlayerPosition(playerPosition);
		this.setMana(mana);
		this.setCo2(co2);
		this.setIsActive(true);
		this.setRoll(roll);
	}

	// Getters and Setters
	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getCo2() {
		return co2;
	}

	public void setCo2(int co2) {
		this.co2 = co2;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", mana=" + mana + ", co2=" + co2 + ", playerNumber=" + playerNumber
				+ ", playerPosition=" + playerPosition + "]";
	}
	
	public void printStats() {
		System.out.printf("Player %d:\t\t%s",playerNumber, playerName);
		System.out.printf("\nCurrent mana reserves:\t%d",mana);
		System.out.printf("\nCurrent CO2 impact:\t%d",co2);
		System.out.printf("\nCurrent board position:\t%d",playerPosition);
	}

}
