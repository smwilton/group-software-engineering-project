/**
 * 
 */
package druidsAndMana;

import java.util.Comparator;

/**
 * @author Dave
 *
 */
public class CompareByRoll implements Comparator<Player> {

	/**
	 * A Comparator to allow us to sort the list of players by a dice roll at the beginning of the game. 
	 */
	@Override
	public int compare(Player player1, Player player2) {
		
		return player2.getRoll()-player1.getRoll();
	}

}
