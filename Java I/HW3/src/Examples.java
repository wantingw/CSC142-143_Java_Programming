import uwcse.io.Input;
public class Examples {
	public static void main(String[] agrs) {
		// local variable, not outside of the method
		// in only can be used within the main 
		//Input in= new Input();
		int i= 10;
		StringBuffer sb = new StringBuffer("abc");
		modify(sb,i);
		System.out.println("sb = "+ sb +", i = "+i);
		// read an integer from the keyboard
		//int jars= in.readInt("How many jars of maple syrup? "); // put a space after question
		//System.out.println("You just bought " + jars + " jars of maple syrup.");
	}
	public static void modify(StringBuffer sb, int i) {
		i*=2;
		sb.reverse();
		
	}

}
