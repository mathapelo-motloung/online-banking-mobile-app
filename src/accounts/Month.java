package accounts;

public enum Month {
	
	JANUARY("January"),
	FEBRUARY("February"),
	MARCH ("March"),
	APRIL ("April"),
	MAY ("May"),
	JUNE ("June"),
	JULY ("July"),
	AUGUST ("August"),
	SEPTMBER ("September"),
	OCTOBER ("October"),
	NOVEMBER ("Novemver"),
	DECEMBER ("December");
	
	
	private final String value;

    Month(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
    
	// To String is not compatible with enums
}
