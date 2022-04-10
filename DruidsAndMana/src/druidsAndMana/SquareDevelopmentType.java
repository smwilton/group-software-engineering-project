package druidsAndMana;

public enum SquareDevelopmentType {

	Vacant(1),
	Grassland(2),
	SeedlingForest(3),
	IntermediateForest(4),
	EstablishedForest(5),
	WildlifeSanctuary(6){
		@Override
		public SquareDevelopmentType next() {
			return null;
		};
	};
	
	private int value;
	
	SquareDevelopmentType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public SquareDevelopmentType next() {
		return values()[ordinal() + 1];
	}
}
