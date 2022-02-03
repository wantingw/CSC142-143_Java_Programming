import uwcse.io.Input; // use the Input class
import java.text.DecimalFormat; // to format the output
import java.lang.Math; // Use to round the total amount 

/**
 * Homework 3 
 * Simulating a purchase in Canada paid in US dollars
 * 
 * @author wan-ting.wu 
 */

public class CanadianGiftShop {

	// Constants
	/** Exchange rate 1 US dollar = RATE Canadian dollar */
	public final double RATE = 1.16;

	/** Price of a jar of maple syrup in Canadian dollars before taxes */
	public final double JAR_PRICE = 5.95;

	/**
	 * Price of photograph of the city of Victoria in Canadian dollars before
	 * taxes
	 */
	public final double PHOTO_PRICE = 7.65;

	/** Price of a beaver hat in Canadian dollars before taxes */
	public final double HAT_PRICE = 16.35;

	/** Maximum allowed number of purchased items for each item */
	public final int MAX_ITEM = 100;

	/** Tax rate */
	public final double TAX_RATE = 0.093;

	// instance variables
	// number of purchased jars of maple syrup
	private int jarNumber;

	// number of purchased photographs of the city of Victoria
	private int photoNumber;

	// number of purchased beaver hats
	private int hatNumber;

	// 2 digits after the decimal point for doubles
	private DecimalFormat twoDigits = new DecimalFormat("0.00");
	
	// Cost amount in Candian and pay amount in US
	private double costCA, payUS;
	
	// Create a new input object to get user input
	Input in= new Input();
	
	// 

	/**
	 * Takes and processes the order from the customer
	 */
	public void takeAndProcessOrder() {
		// Display the items and their prices
		this.itemList();
		// Get the Customer's order
		// Get the user's USD payment
		this.input();
		// Give the change back in Canadian dollars
		this.changeinCAD(payUS, costCA);

	}

	/**
	 * Displays the items for sale and their prices in Canadian dollars
	 */
	private void itemList() {
		
		// Greeting to customers
		System.out.println("				Welcome to Canadian Wonders\n	"
				+ 		   "			***************************		");
		System.out.println("");
		System.out.println("Here is a price list of our most popular products (in Canadian dollars)");
		System.out.println("");
		
		// Display the items with prices
		System.out.println("Jar of Maple Syrup: $5.95"
							+"\nPhotograph of Victoria: $7.65"
							+"\nBeaver Hat: $16.35");
		System.out.println("");
		
		// Display the tax rate and tranfer rate
		System.out.println("The above prices don‘t include taxes. The tax rate is 9.30%\n" + 
				"Our exchange rate is 1 US dollar =1.16 Canadian dollars");

		
	
	}

	/**
	 * Gets the customer's order Precondition: none Postcondition: jarNumber,
	 * photoNumber and hatNumber are initialized to a value between 0 and
	 * MAX_ITEM
	 */
	private void input() {
		// Call the readIn methond in UW library to get user item amount input
		// Call the method contralInput to check and contral user inputs on the amount of items
		this.jarNumber = in.readInt("How many jars of maple syrup would you like? ");
		this.jarNumber= contralInput(this.jarNumber);
		this.photoNumber = in.readInt("How many photographs of Victoria would you like?");
		this.photoNumber= contralInput(this.photoNumber);
		this.hatNumber= in.readInt("How many beaver hats would you like?");
		this.hatNumber=contralInput(this.hatNumber);

		// Calculate the total cost in Canadian
		this.costCA = (this.JAR_PRICE * this.jarNumber + this.HAT_PRICE * this.hatNumber
				+ this.PHOTO_PRICE * this.photoNumber)*(1+this.TAX_RATE);	
		
		// Display the purchase total using twoDigits format
		System.out.println("Your purchase total is $ "+ twoDigits.format(this.costCA) + " CA (tax included)");
		
		// Ask the user to input the amount of currency to pay for the purchase
		this.payUS= in.readDouble("Please enter the US dollar amount to pay for it: ");
		
		// Check that the user gave enough money. 
		// If not, say so to the user and end the program.
		if (this.payUS*this.RATE< this.costCA) {
			System.out.println("Sorry, that is not enough for the order.");
			System.exit(0);
		}
		
		// Display the amount of US received and transfer to CA.
		System.out.println("You gave $"+ twoDigits.format(payUS)+ " US, which is $"
							+ twoDigits.format(payUS*this.RATE)+" CA");

		
		
		
		
	}
	/**
	 * Check and Control the user input of item amount
	 * The input should be the integral between 0 and 100
	 * If a number of items is not 0 and 100, set it to 0. 
	 * @param number 
	 * 				item amount
	 */	
	private int contralInput(int number) {
		if (number<0) {
			System.out.println(number + " is not a valid number of items!");
			return 0;
		}else if(number>100) {
			System.out.println("Sorry, we don't have that many in stock.");
			return 0;
		} else
			return number;
	}
		
		
		

	/**
	 * Given a purchase in canadian dollars and a payment in US dollars,
	 * displays the change amount in canadian dollars and cents
	 * 
	 * @param payUS
	 *            payment in US dollars
	 * @param costCA
	 *            purchase amount in Canadia dollars
	 */
	private void changeinCAD(double payUS, double costCA) {
		// Round the cost amount and pay amount 
		costCA= Math.round(this.costCA*100);
		payUS= Math.round(this.payUS*this.RATE*100);
		
		// Calculate the change 
		double change = payUS-costCA;
		System.out.println("Here is your change: "+ twoDigits.format(change/100) + " CA");
		
		// Break up the change amount in 20, 10, 2, and 1 bills
		// and 25c, 10c, 5c, and 1c coins.
		int twentyDollars= (int) (change / 2000);
		int tenDollars= (int) (change % 2000 / 1000);
		int fiveDollars= (int) (change % 1000 / 500);
		int oneDollar= (int) (change % 1000 % 500 / 100);
		
		int twentyfiveCents= (int) (change % 100 / 25);
		int tenCents= (int) (change % 100 % 25 / 10);
		int fiveCents= (int) (change % 100 % 25 % 10 / 5) ;
		int oneCent= (int) (change % 100 % 25 % 10 % 5 / 1);
		
		// Use conditional display the outputs of receipt
		if (twentyDollars==1) {
			System.out.println( twentyDollars + " $20 bill");
		}else if (twentyDollars>1) {
			System.out.println(twentyDollars + " $20 bills");
		}
		
		if (tenDollars==1) {
			System.out.println( tenDollars + " $10 bill");
		}else if (tenDollars>1) {
			System.out.println(tenDollars + " $10 bills");
		}
		
		if (fiveDollars==1) {
			System.out.println( fiveDollars + " $5 bill");
		}else if (fiveDollars>1) {
			System.out.println(fiveDollars + " $5 bills");
		}
		
		if (oneDollar==1) {
			System.out.println( oneDollar + " $1 bill");
		}else if (oneDollar>1) {
			System.out.println( oneDollar + " $1 bills");
		}
		
		if (twentyfiveCents==1) {
			System.out.println( twentyfiveCents + " 25c coin");
		}else if (twentyfiveCents>1) {
			System.out.println(twentyfiveCents + " 25c coins");
		}
		
		if (tenCents==1) {
			System.out.println( tenCents + " 10c coin");
		}else if (tenCents>1) {
			System.out.println(tenCents + " 10c coins");
		}
		
		if (fiveCents==1) {
			System.out.println( fiveCents + " 5c coin");
		}else if (fiveCents>1) {
			System.out.println(fiveCents + " 5c coins");
		}
		
		if (oneCent==1) {
			System.out.println( oneCent + " 1c coin");
		}else if (oneCent>1) {
			System.out.println( oneCent + " 1c coins");
		}
		
		System.out.println("Thank you for your business!");
	}

	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {
		new CanadianGiftShop().takeAndProcessOrder();
	}

}
