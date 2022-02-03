
public class Cards {
	private String suit;
	private int value;
	
	public Cards (String suit, int value) {
		// if the value is out of range, set to the default value
		if (value <2 || value >14) {
			value =2;
		} else { 
			this.value=value;
		}
		this.suit=suit;
		this.value=value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
}
