/**
 * Chaptr 10 Iterations
 * @author wantingwu
 *
 */
public class Conditional {
	
	/* Java has three iteration constructs
	 1. while loop
	 2. do-while loop
	 3. for loop
	 loops can be rewrittern using among these three constructs */
	public static void main(String[] args) {
		int n=0;
        for(int i=1;i<=n/2+1;i++){
            for(int j=1;j<=i;j++)
                System.out.print("*");
            System.out.println("");
        }
        
        for(int i=1;i<=n/2;i++){
            for(int j=1;j<=n/2-i+1;j++)
                System.out.print("*");
            System.out.println("");
        }
}
}