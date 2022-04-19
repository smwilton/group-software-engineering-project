package druidsAndMana;

import java.util.ArrayList;

/**
 * 
 * @author pete
 *
 */

public class MockGameBoard implements IGameBoard {

	public ISquare getMockSquare() {
		return mockSquare;
	}
	
	public void setManaCharge(int charge) {
		this.manaCharge = charge;
	}
	
	public int getManaCharge() {
		return this.manaCharge;
	}
	
	private int manaCharge;
	private ISquare mockSquare;
	
	public MockGameBoard(ISquare mockSquare) {
		this.mockSquare = mockSquare;
	}
	
	@Override
	public int newsquarePosition(int playerCurrentPosition, int placesToMove) {
		return 0;
	}

	@Override
	public boolean squareIsGrassland(int squareIndex) {
		return mockSquare instanceof Grassland;
	}

	@Override
	public String squareDescription(int squareIndex) {
		return mockSquare.description();
	}

	@Override
	public String squareAsciiArt(int squareIndex) {
		return mockSquare.asciiArt();
	}

	@Override
	public int manaCharge(int squareIndex) {
		return manaCharge;
	}

	@Override
	public int getSquareOwnerId(int squareIndex) {
		if(mockSquare instanceof Grassland) {
			Grassland mockSquareGrassland = (Grassland)mockSquare;
			return mockSquareGrassland.getOwnerId();
		}
		
		return 0;
	}

	@Override
	public int getCO2Modifier(int squareIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Grassland> getAllPlayerOwnedGrasslands(
			Player currentPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setSquareOwnerId(int squareIndex, int playerId) {
		if(mockSquare instanceof Grassland) {
			Grassland mockSquareGrassland = (Grassland)mockSquare;
			mockSquareGrassland.setInitialOwnerId(1);
			return true;
		}
		return false;
	}

	@Override
	public boolean playerCanUpgrade(int playerId, int squareIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int costToUpgrade(int squareIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SquareStatus getSquareType(int squareIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upgradeGrassland(int squareIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ISquare[] getSquares() {
		// TODO Auto-generated method stub
		return null;
	}

}
