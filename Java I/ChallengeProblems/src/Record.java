/**
 * 
 * @author wantingwu
 * CSC143-Challenging one
 */

public class Record {

	
	public static void main (String args[]) {
		
		Customers mark1 = new Customers ("Mark", "Brown", 31, "Clover Street", "Red");
		Customers mark2 = new Customers ("Mark", "Jones", 33, "Clover Street", "Black");
		Customers mark3 = new Customers ("Mark", "Brown", 33, "Grover Street", "Grey");
		
		printer(mark1,mark2,mark3);
		specialArrange(mark1, mark2, mark3);
	
	}

	
	/**
	 * The specialArrange method is created for made rearrange to move mark3 to the front of mark1 and mark2;
	 * By utilized the equals method we first compare their information, if the information is identical, meaning
	 * it is the same person then we don't need to do the swap. Otherwise, we swap for these three customers
	 * and immediately pass the value into the printer method for printing out the revised order.
	 */
	public static void specialArrange(Customers mark1, Customers mark2, Customers mark3) {
		Customers m1 = mark1;
		Customers m2 = mark2;
		if(!mark1.equals(mark3)){
			mark1 = mark3;
		}
		if(!mark2.equals(m1)) {
			mark2 = m1;
		}
		if(!mark3.equals(m2)) {
			mark3 = m2;
		}
		printer(mark1, mark2, mark3);
	}
	
    
	public static void printer(Customers m1, Customers m2, Customers m3) {
		System.out.println("Your customer wailist is sorted: \n" + m1.toString() + m2.toString() + m3.toString() );
	}
	
	
 
    
	
}
