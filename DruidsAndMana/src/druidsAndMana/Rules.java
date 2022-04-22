package druidsAndMana;

/**
 * 
 * @author sandra
 *
 */
public class Rules {

	// Vars for getting Grassland values to populate rules
	private GameBoardBuilder board = new GameBoardBuilder();
	private GameAdmin admin = new GameAdmin(new ConsoleInputService(), new ConsoleOutputService(), new GameBoard(board));
	private ISquare squares[] = board.buildGameBoard();
	private Grassland tropical,subtropical,temperate,boreal;
	private int numTropical, numSubtropical,numTemperate, numBoreal, 
	costToBuyTropical, costToBuySubtropical, costToBuyTemperate, costToBuyBoreal,
	costForestTropical, costForestSubtropical,costForestTemperate, costForestBoreal,
	costWSTropical, costWSSubtropical, costWSTemperate, costWSBoreal,
	grasslandCo2Tropical, grasslandCo2Subtropical, grasslandCo2Temperate, grasslandCo2Boreal,
	grasslandLandingTropical, grasslandLandingSubtropical, grasslandLandingTemperate, grasslandLandingBoreal,
	seedlingCo2Tropical, seedlingCo2Subtropical, seedlingCo2Temperate, seedlingCo2Boreal,
	seedlingLandingTropical, seedlingLandingSubtropical, seedlingLandingTemperate, seedlingLandingBoreal,
	intermediateCo2Tropical, intermediateCo2Subtropical, intermediateCo2Temperate, intermediateCo2Boreal,
	intermediateLandingTropical, intermediateLandingSubtropical, intermediateLandingTemperate, intermediateLandingBoreal,
	establishedCo2Tropical, establishedCo2Subtropical, establishedCo2Temperate, establishedCo2Boreal,
	establishedLandingTropical, establishedLandingSubtropical, establishedLandingTemperate, establishedLandingBoreal,
	wildlifeSCo2Tropical, wildlifeSCo2Subtropical, wildlifeSCo2Temperate, wildlifeSCo2Boreal,
	wildlifeSLandingTropical, wildlifeSLandingSubtropical, wildlifeSLandingTemperate, wildlifeSLandingBoreal, startMana;

	private String ruleText;
	
	public Rules() {
		this.setRuleValues();
	}
	
	private void setRuleValues() {
		this.numTropical = 0;
		this.numSubtropical = 0;
		this.numTemperate = 0;
		this.numBoreal = 0;
		
		for (ISquare square : squares) {
			if(square instanceof Tropical) {
				tropical = (Grassland)square;
				numTropical++;
			} else if(square instanceof Subtropical) {
				subtropical = (Grassland)square;
				numSubtropical++;
			}else if(square instanceof Temperate) {
				temperate = (Grassland)square;
				numTemperate++;
			}else if(square instanceof Boreal) {
				boreal = (Grassland)square;
				numBoreal++;
			}
			
		}
		
		// VACANT STATUS
		this.costToBuyTropical = tropical.getDevelopmentCost();
		this.costToBuySubtropical = subtropical.getDevelopmentCost();
		this.costToBuyTemperate = temperate.getDevelopmentCost();
		this.costToBuyBoreal = boreal.getDevelopmentCost();
		
		// GRASSLAND STATUS
		tropical.developGrassland();
		subtropical.developGrassland();
		temperate.developGrassland();
		boreal.developGrassland();
		
		this.costForestTropical = tropical.getDevelopmentCost();
		this.costForestSubtropical = subtropical.getDevelopmentCost();
		this.costForestTemperate = temperate.getDevelopmentCost();
		this.costForestBoreal = boreal.getDevelopmentCost();
		
		this.grasslandCo2Tropical = tropical.getCo2ReductionRating();
		this.grasslandCo2Subtropical = subtropical.getCo2ReductionRating();
		this.grasslandCo2Temperate = temperate.getCo2ReductionRating(); 
		this.grasslandCo2Boreal = boreal.getCo2ReductionRating();
		this.grasslandLandingTropical = tropical.getChargeForLandingOnSquare(); 
		this.grasslandLandingSubtropical = subtropical.getChargeForLandingOnSquare();
		this.grasslandLandingTemperate = temperate.getChargeForLandingOnSquare();
		this.grasslandLandingBoreal = boreal.getChargeForLandingOnSquare();
		
		// SEEDLING STATUS
		tropical.developGrassland();
		subtropical.developGrassland();
		temperate.developGrassland();
		boreal.developGrassland();	
		
		this.seedlingCo2Tropical = tropical.getCo2ReductionRating();
		this.seedlingCo2Subtropical = subtropical.getCo2ReductionRating();
		this.seedlingCo2Temperate = temperate.getCo2ReductionRating(); 
		this.seedlingCo2Boreal = boreal.getCo2ReductionRating();
		this.seedlingLandingTropical = tropical.getChargeForLandingOnSquare(); 
		this.seedlingLandingSubtropical = subtropical.getChargeForLandingOnSquare();
		this.seedlingLandingTemperate = temperate.getChargeForLandingOnSquare();
		this.seedlingLandingBoreal = boreal.getChargeForLandingOnSquare();
		
		
		// INTERMEDIATE STATUS
		tropical.developGrassland();
		subtropical.developGrassland();
		temperate.developGrassland();
		boreal.developGrassland();
		
		this.intermediateCo2Tropical = tropical.getCo2ReductionRating();
		this.intermediateCo2Subtropical = subtropical.getCo2ReductionRating();
		this.intermediateCo2Temperate = temperate.getCo2ReductionRating(); 
		this.intermediateCo2Boreal = boreal.getCo2ReductionRating();
		this.intermediateLandingTropical = tropical.getChargeForLandingOnSquare(); 
		this.intermediateLandingSubtropical = subtropical.getChargeForLandingOnSquare();
		this.intermediateLandingTemperate = temperate.getChargeForLandingOnSquare();
		this.intermediateLandingBoreal = boreal.getChargeForLandingOnSquare();
		
		// ESTABLISHED STATUS
		tropical.developGrassland();
		subtropical.developGrassland();
		temperate.developGrassland();
		boreal.developGrassland();
		
		this.costWSTropical = tropical.getDevelopmentCost();
		this.costWSSubtropical = subtropical.getDevelopmentCost();
		this.costWSTemperate = temperate.getDevelopmentCost();
		this.costWSBoreal = boreal.getDevelopmentCost();
		
		this.establishedCo2Tropical = tropical.getCo2ReductionRating();
		this.establishedCo2Subtropical = subtropical.getCo2ReductionRating();
		this.establishedCo2Temperate = temperate.getCo2ReductionRating(); 
		this.establishedCo2Boreal = boreal.getCo2ReductionRating();
		this.establishedLandingTropical = tropical.getChargeForLandingOnSquare(); 
		this.establishedLandingSubtropical = subtropical.getChargeForLandingOnSquare();
		this.establishedLandingTemperate = temperate.getChargeForLandingOnSquare();
		this.establishedLandingBoreal = boreal.getChargeForLandingOnSquare();
		
		// WILDLIFE RESERVE STATUS
		tropical.developGrassland();
		subtropical.developGrassland();
		temperate.developGrassland();
		boreal.developGrassland();
		
		this.wildlifeSCo2Tropical = tropical.getCo2ReductionRating();
		this.wildlifeSCo2Subtropical = subtropical.getCo2ReductionRating();
		this.wildlifeSCo2Temperate = temperate.getCo2ReductionRating(); 
		this.wildlifeSCo2Boreal = boreal.getCo2ReductionRating();
		this.wildlifeSLandingTropical = tropical.getChargeForLandingOnSquare(); 
		this.wildlifeSLandingSubtropical = subtropical.getChargeForLandingOnSquare();
		this.wildlifeSLandingTemperate = temperate.getChargeForLandingOnSquare();
		this.wildlifeSLandingBoreal = boreal.getChargeForLandingOnSquare();
		
		// GET START MANA
		this.startMana = admin.getStartMana();
	}
	
	public String displayRules() {
		// Display rules in console
		//outputService.println(ruleText);
		 ruleText = "Game Guide \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "Game Premise \n"
					+ "\n"
					+ "Players, hereafter named ‘Druids’ advance around the board, building up and using their mana reserves to acquire Grassland within Realms. The goal is to acquire all Grassland within a Realm and then develop these Grasslands into prospering\n"
					+"forests in order to combat the effect unsustainable logging and deforestation has had on global warming and wildlife’s habitats; restoring health to the planet. Mana will also be given to rival Druids when resting in their forests to \n"
					+"contribute to the upkeep of those Grasslands and help in the worldwide fight to save the planet from destruction! \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "Objective \n"
					+ "\n"
					+ "Druids aim to acquire all Grasslands within as many Realms as they can so the Grasslands can be developed, maximizing their contribution in the fight to save the planet. Play ends either when only one Druid remains controlling the entire\n"
					+"board, or when a Druid chooses to end the game. When the game ends the winner will be the Druid who has made the biggest difference. This contribution is measured by the Druid who have the highest CO2 Reduction Rating when the game ends.\n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "Preparation \n"
					+ "\n"
					+ "The game has 2 to 4 druids \n"
					+ "\n"
					+ "The druids' names are enter at the beginning of the gameplay. \n"
					+ "\n"
					+ "Druids take turns to throw two virtual dice at the time of their turn. \n"
					+ "\n"
					+ "The combined number of the dice dictates how many grasslands the druid can pass through. \n"
					+ "\n"
					+ "Each druid has a starting mana balance of "+String.format("%,d",startMana)+" mana points and a CO2 reduction rating of 0. \n"
					+ "\n"
					+ "Before the game commences, druids will each roll the dice. Turns will be taken in order of dice roll from the highest to lowest dice roll, in the event of a tie dice will be rolled again. \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "What is mana? \n"
					+ "\n"
					+ "Mana is the Druid’s power and is used as the resource to exchange for grassland, developments, upgrades and when visiting other Druid’s grassland.\n"
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
					+ "Ending your turn on the Sacred Alder Square grants an additional 100-mana bonus, bringing the total earned to 200 mana instead\n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "Forest Squares \n"
					+ "\n"
					+ "There are 4 realms each with a number of grasslands as shown in the table below \n"
					+ "\n"
					+ "At the beginning of the game each grassland is vacant. \n"
					+ "\n"
					+ "When a Druid lands on a vacant grassland they can choose to invest the required mana points to acquire that grassland or, alternatively, choose not buy, thus leaving the grassland vacant.\n"
					+ "\n"
					+ "The cost to acquire a grassland varies depending on the realm it is part of (see \"Charges\" section). \n"
					+ "\n"
					+ "When the druid acquires the grassland they are then considered to \"own\" it and from thereon in, any other druid who lands on the grassland will be required to contribute mana towards the upkeep of that area. This \"fee\" will \n"
					+"vary depending on what realm the grassland is in, and how developed it is. The \"fee\" will be transferred to the owner of the area (see \"Landing on an Opponent\'s Grassland\" section for details on this). \n"
					+ "\n"
					+ "A druid must own all grasslands within a realm before they can begin to develop any of their grasslands (see \"Planting Forest\" section for details on this). \n"
					+ "\n"
					+ "Once a Druid has planted 3 forests on their grassland they can implement an upgrade (see \"Upgrading to wildlife sanctuary\" section for details on this). \n"
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
					+ "Landing on an Opponent\'s Grassland \n"
					+ "\n"
					+ "Landing on an \"owned\" grassland results in the druid having to pay a mana \"fee\" towards the upkeep of the grassland as they pass through. \n"
					+ "\n"
					+ "The \"fee\" per grassland varies depending on which realm it is in and how many developments have been done on that grassland (see \"Charges\" section). \n"
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
					+ "For each forest a druid plants the environmental benefits they have made increase and in turn the amount of CO2 reduction rating points they achieve each turn increases. This also results in a higher upkeep fee for visitors to the forest \n"
					+"(See \"Charges\" and \"CO2 reduction ratings\" section). \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "Upgrading to wildlife sanctuary \n"
					+ "\n"
					+ "Once a druid has planted 3 forests on their grassland they can then chose to upgrade that grassland to a wildlife sanctuary. The cost of doing so varies depending on the realm the grassland is located (See \"Charges\" section). \n"
					+ "\n"
					+ "Converting their grassland to a wildlife sanctuary is the biggest achievement a druid can make in their quest to save the world. As a result the wildlife sanctuary the amount of CO2 reduction rating points they achieve each turn increases \n"
					+"further. This also results in a higher upkeep fee for visitors to the forest (See \"Charges\" and \"CO2 reduction ratings\" section). \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "Mana Depletion \n"
					+ "\n"
					+ "If a Druid lands on another Druid’s grassland but has insufficient mana to pay the fee towards the upkeep of that grassland they are considered inactive and can no longer participate in the game.\n"
					+ "\n"
					+ "At this point all grasslands belonging to this Druid will transfer to the Druid who is the owner of the grassland that they have finished on.\n"
					+ "\n"
					+ "At this point they will NO longer accrue points against their CO2 reduction rating per turn. However, their total consumption at the time they finished the game is saved as their final score and included in the leaderboard at the end of the \n"
					+"game when determining the winner (see \"Winning the Game section). \n"
					+ "\n"
					+ " \n"
					+ "\n\n"
					+"\tREALM 		| NO. OF GRASSLANDS | COST* TO ACQUIRE 1 GRASSLAND | COST OF 1 FOREST | COST OF WILDLIFE SANCTUARY UPGRADE | COST OF LANDING ON GRASSLAND(based on no. developments - 0, 1, 2, 3 or 4)\n"
					+"_____________________________________________________________________________________________________________________________________________________________________________________________________________"
					+"																																	"
					+ "\n\n\tTropical	"
					+ "\t"+numTropical+"		"+costToBuyTropical+"				"+costForestTropical+"			"+costWSTropical+"				"
				
					+ grasslandLandingTropical+"\t"+seedlingLandingTropical+"\t"+intermediateLandingTropical+"\t"+establishedLandingTropical+"\t"+wildlifeSLandingTropical+" \n"
					+"\n\tSubtropical	"
					+ "\t"+numSubtropical+"		"+costToBuySubtropical+"				"+costForestSubtropical+"			"+costWSSubtropical+"				"
				
					+ grasslandLandingSubtropical+"\t"+seedlingLandingSubtropical+"\t"+intermediateLandingSubtropical+"\t"+establishedLandingSubtropical+"\t"+wildlifeSLandingSubtropical+" \n"
					+ "\n\tTemperate	"
					+ "\t"+numTemperate+"		"+costToBuyTemperate+"				"+costForestTemperate+"			"+costWSTemperate+"				"
				
					+ grasslandLandingTemperate+"\t"+seedlingLandingTemperate+"\t"+intermediateLandingTemperate+"\t"+establishedLandingTemperate+"\t"+wildlifeSLandingTemperate+" \n"
					+"\n\tBoreal	"
					+ "\t\t"+numBoreal+"		"+costToBuyBoreal+"				"+costForestBoreal+"			"+costWSBoreal+"				"
				
					+ grasslandLandingBoreal+"\t"+seedlingLandingBoreal+"\t"+intermediateLandingBoreal+"\t"+establishedLandingBoreal+"\t"+wildlifeSLandingBoreal+" \n"
					
					+ "\n"
					+ "(*all costs in manna points) \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "CO2 reduction ratings \n"
					+ "\n"
					+ "For each turn a druid will accrue points against their CO2 reduction rating. This represents the beneficial impact their grasslands are having on CO2 emissions. \n"
					+ "\n"
					+ "The amount accrued on each turn is dependent upon the status of each grassland the druid owns. \n"
					+ "\n"
					+ "Druids who own no grassland will accrue no points towards their CO2 reduction rating. \n"
					+ "\n\n\n"
					+ "Realm \t\t\t"
					+ "CO2 reduction rating earned per turn per grassland owned (based on no. developments - 0, 1, 2, 3 or 4) \n"
					+"___________________________________________________________________________________________________________________________"
					+ "\n"
					+ "Tropical \t\t\t"
					+ grasslandCo2Tropical+"\t"+seedlingCo2Tropical+"\t"+intermediateCo2Tropical+"\t"+establishedCo2Tropical+"\t"+String.format("%,d",wildlifeSCo2Tropical)+" \n\n"
					+ "Subtropical \t\t\t"
					+ grasslandCo2Subtropical+"\t"+seedlingCo2Subtropical+"\t"+intermediateCo2Subtropical+"\t"+establishedCo2Subtropical+"\t"+wildlifeSCo2Subtropical+" \n\n"
					+ "Temperate \t\t\t"
					+ grasslandCo2Temperate+"\t"+seedlingCo2Temperate+"\t"+intermediateCo2Temperate+"\t"+establishedCo2Temperate+"\t"+wildlifeSCo2Temperate+" \n\n"
					+ "Boreal \t\t\t\t"
					+ grasslandCo2Boreal+"\t"+seedlingCo2Boreal+"\t"+intermediateCo2Boreal+"\t"+establishedCo2Boreal+"\t"+wildlifeSCo2Boreal+" \n\n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ " \n"
					+ "\n"
					+ "Winning The Game \n"
					+ "\n"
					+ "The game ends either when only one player has mana remaining (i.e., is active) or when any one player wishes to leave the game. \n"
					+ "\n"
					+ "The mana balance of each Druid is displayed at the end of the game along with their CO2 reduction points. \n"
					+ "\n"
					+ "As mana is a resource, and the objective of the game is to reward spending of mana to make a difference positive impact towards saving the world, rather than hoarding it just to hold the highest balance, the ending mana \n"+
					"balance will not be used as the metric to determine the winner of the game. \n"
					+ "\n"
					+ "At the end of the game the druid who has consumed the most CO2 is the winner of the game, i.e. the druid with the highest CO2 reduction rating. \n"
					+ "\n"
					+ "In the event of a tie, where more than 1 Druid has the highest CO2 reduction rating, the game is ended with a draw between those players.\n"
					+ "\n"
					+ "The winning druid does not need to be an active druid when the game ends. ";
		return ruleText;
	}
	
}
