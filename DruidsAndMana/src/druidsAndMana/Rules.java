package druidsAndMana;

/**
 * 
 * @author sandra
 *
 */
public class Rules {

	private IInputService inputService;
	private GameEngine gameEngine;
	private String ruleText = "Game Guide \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Game Premise \n"
			+ "\n"
			+ "Players, hereafter named ‘Druids’ advance around the board, building up and using their mana reserves to acquire grassland. The goal is to develop these grasslands into prospering forests in order to combat the effect unsustainable logging and deforestation has had on global warming and wildlife’s habitats; restoring health to the planet. Mana will also be given to rival druid’s when resting in their forests to contribute to the worldwide fight and save the planet from destruction! \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Objective \n"
			+ "\n"
			+ "Druids aim to acquire and develop as many grasslands as they can, maximizing their contribution in the fight to save the planet. Play ends either when only one druid remains controlling the entire board, or when a druid chooses to end the game. When the game ends the winner will be the druid who has made the biggest difference. \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Preparation \n"
			+ "\n"
			+ "The game has 2 to 4 druids \n"
			+ "\n"
			+ "The druids’ names are enter at the beginning of the gameplay. \n"
			+ "\n"
			+ "Druids take turns to throw two virtual dice at the time of their turn. \n"
			+ "\n"
			+ "The combined number of the dice dictates how many grasslands the druid can pass through. \n"
			+ "\n"
			+ "Each druid has a starting mana balance of 1,500 mana points and a CO2 impact rating of 0. \n"
			+ "\n"
			+ "Before the game commences, druids will each roll the dice. Turns will be taken in order of dice roll from the highest to lowest dice roll, in the event of a tie dice will be rolled again. \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "What is mana? \n"
			+ "\n"
			+ "Mana is the druid’s power and is used as the resource to exchange for grassland, developments, upgrades and when visiting other druid’s grassland \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "The Board :\n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Sacred Alder Square \n"
			+ "\n"
			+ "The Sacred Alder square is the birthplace of the druids, and as such, it is where play begins. \n"
			+ "\n"
			+ "After every full rotation of the board, druids are granted 100 mana as they pass the Sacred Alder Square to ymbolize them restoring their magical energy in their sanctuary. \n"
			+ "\n"
			+ "Ending your turn on the Sacred Alder Square grants a 200-mana bonus instead of the 100 mana for passing by. \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Forest Squares \n"
			+ "\n"
			+ "There are 4 realms each with a number of grasslands as shown in the table below \n"
			+ "\n"
			+ "At the beginning of the game each grassland is vacant. \n"
			+ "\n"
			+ "When a druid lands on a vacant grassland they can chose to invest the required mana points to acquire that grassland or, alternatively, offer another druid the opportunity to acquire the grassland in their place.  \n"
			+ "\n"
			+ "The cost to acquire a grassland varies depending on the realm it is part of (see ‘Charges’ section). \n"
			+ "\n"
			+ "When the druid acquires the grassland they are then considered to “own” it and from thereon in, any other druid who lands on the grassland will be required to contribute mana towards the upkeep of that area. This “fee” will vary depending on what realm the grassland is in, and how developed it is. The “fee” will be transferred to the owner of the area (see ‘Landing on an Opponent’s Grassland’ section for details on this). \n"
			+ "\n"
			+ "A druid must own all grasslands within a realm before they can begin to develop any of their grasslands (see ‘Planting Forest’ section for details on this). \n"
			+ "\n"
			+ "Once a druid has planted 3 forests on their grassland they can implement an upgrade (see ‘Upgrading to wildlife sanctuary’ section for details on this). \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Scenic Viewpoint \n"
			+ "\n"
			+ "The scenic viewpoint represents a safe place for the druids to stop. There are no consequences for landing on this square. \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Landing on an Opponent’s Grassland \n"
			+ "\n"
			+ "Landing on an “owned” grassland results in the druid having to pay a mana “fee” towards the upkeep of the grassland as they pass through. \n"
			+ "\n"
			+ "The “fee” per grassland varies depending on which realm it is in and how many developments have been done on that grassland (see ‘Charges’ section). \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Planting forests \n"
			+ "\n"
			+ "Once a druid owns all grasslands within a realm they can begin to plant forests in any of their grasslands. \n"
			+ "\n"
			+ "The cost of planting a forest varies depending on the realm it is in. The costs are outlined in the Charges section.  \n"
			+ "\n"
			+ "If a druid has sufficient mana, on their turn, they can repopulate the grassland that they own even if they are not positioned on that area. \n"
			+ "\n"
			+ "When 3 forests have been planted in a grassland the druid is then eligible to upgrade this grassland to a wildlife sanctuary. \n"
			+ "\n"
			+ "For each forest a druid plants the environmental benefits they have made increase and in turn the amount of CO2 impact points they achieve each turn increases. This also results in a higher upkeep fee for visitors to the forest (See ‘Charges’ and ‘CO2 impact ratings’ section). \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Upgrading to wildlife sanctuary \n"
			+ "\n"
			+ "Once a druid has planted 3 forests on their grassland they can then chose to upgrade that grassland to a wildlife sanctuary. The cost of doing so varies depending on the realm the grassland is located (See ‘Charges’ section). \n"
			+ "\n"
			+ "Converting their grassland to a wildlife sanctuary is the biggest achievement a druid can make in their quest to save the world. As a result the wildlife sanctuary the amount of CO2 impact points they achieve each turn increases further. This also results in a higher upkeep fee for visitors to the forest (See ‘Charges’ and ‘CO2 impact ratings’ section). \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Mana Depletion \n"
			+ "\n"
			+ "If a druid lands on another druids grassland and cannot afford to pay the fee towards the upkeep of that grassland, but owns an empty grassland that has not been developed, they can release ownership of that grassland in order to recuperate the mana that was paid to acquire that grassland, and therefore in turn pay the fee to the owner of the grassland they have landed on. \n"
			+ "\n"
			+ "If a druid lands on another druid’s grassland but has insufficient mana to pay the fee towards the upkeep of that grassland they are considered inactive and can no longer participate in the game. \n"
			+ "\n"
			+ "At this point all grasslands and any remaining mana balance belonging to this druid will transfer to the druid who is the owner of the grassland that they have finished on. \n"
			+ "\n"
			+ "At this point they will NO longer accrue points against their CO2 impact rating per turn. However, their total consumption at the time they finished the game is saved as their final score and included in the leaderboard at the end of the game when determining the winner (see ‘Winning the Game section). \n"
			+ "\n"
			+ " \n"
			+ "\n\n"
			+"\tREALMS 		| NO. OF GRASSLANDS | COST* TO ACQUIRE 1 GRASSLAND | COST OF 1 FOREST | COST OF WILDLIFE SANCTUARY UPGRADE | COST OF LANDING ON GRASSLAND(based on squares owned) 0 1 2 3 4\n"
			+"_______________________________________________________________________________________________________________________________________________________________________________________"
			+"																																	"
			+ "\n\n\tTropical	"
			+ "\t2		600				60			120				"
		
			+ "6\t12\t18\t24\t60 \n"
			+"\n\tSubtropical	"
			+ "\t3		500				50			100				"
		
			+ "5\t10\t15\t20\t50 \n"
			+ "\n\tTemperate	"
			+ "\t3		400				40			80				"
		
			+ "4\t8\t12\t16\t40 \n"
			+"\n\tBoreal	"
			+ "\t\t2		300				30			60				"
		
			+ "3\t6\t9\t12\t30 \n"
			
			+ "\n"
			+ "(*all costs in manna points) \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "CO2 impact ratings \n"
			+ "\n"
			+ "For each turn a druid will accrue points against their CO2 impact rating. This represents the beneficial impact their grasslands are having on CO2 emissions. \n"
			+ "\n"
			+ "The amount accrued on each turn is dependent upon the status of each grassland the druid owns. \n"
			+ "\n"
			+ "Druids who own no grassland will accrue no points towards their CO2 impact rating. \n"
			+ "\n\n\n"
			+ "Grassland status \t\t"
			+ "CO2 impact rating earned per turn per grassland owned \n"
			+"___________________________________________________________________________________________"
			+ "\n"
			+ "Empty grassland \t\t\t"
			+ "5 \n\n"
			+ "Grassland with 1 forest \t\t"
			+ "15 \n\n"
			+ "Grassland with 2 forests \t\t"
			+ "20 \n\n"
			+ "Grassland with 3 forests \t\t"
			+ "25 \n\n"
			+ "Grassland with wildlife sanctuary \t"
			+ "50 \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ " \n"
			+ "\n"
			+ "Winning The Game \n"
			+ "\n"
			+ "The game ends either when  only one player has mana remaining (i.e., is active) or when only one player  wishes to continue the game \n"
			+ "\n"
			+ "The mana balance of each druid is displayed at the end of the game along with their CO2 impact points.  \n"
			+ "\n"
			+ "As mana is a resource, and the objective of the game is to reward spending of mana to make a difference positive impact towards saving the world, rather than hoarding it just to hold the highest balance, the ending mana balance will not be used as the metric to determine the winner of the game unless in the event of a tie. \n"
			+ "\n"
			+ "At the end of the game the druid who has consumed the most CO2 is the winner of the game, i.e. the druid with the highest CO2 impact rating. \n"
			+ "\n"
			+ "In the event of a tie, where more than 1 druid has the highest CO2 impact rating, the overall winner will be decided by establishing which one has the highest ending mana balance. \n"
			+ "\n"
			+ "The winning druid does not need to be an active druid when the game ends. ";
	
	public Rules(IInputService inputService) {
		this.inputService = inputService;
	}
	
	public String displayRules() {
		// Display rules in console
		System.out.println(ruleText);
		return ruleText;
	}
	
	//Wait for user input		

	public boolean exitRules() {
		return this.inputService.GetUserConfirmation("Have you finished reading the rules?");		
	}
}