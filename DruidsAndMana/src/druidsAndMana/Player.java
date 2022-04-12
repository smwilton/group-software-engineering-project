package druidsAndMana;

/**
 * @author Sandra
 *
 */
public class Player {

	private String playerName;
	private int mana;
	private int co2;
	private int playerNumber;
	private int playerPosition;

	public Player(String playerName, int playerNumber, int playerPosition, int mana, int co2) {
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.playerPosition = playerPosition;
		this.mana = mana;
		this.co2 = co2;
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

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", mana=" + mana + ", co2=" + co2 + ", playerNumber=" + playerNumber
				+ ", playerPosition=" + playerPosition + "]";
	}

}
