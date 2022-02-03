import java.util.LinkedList;
import java.util.Queue;

public class Test {
	public static void mystery3 (Queue<Integer> q) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int n = q.remove();
			if (n>0) {
				q.add(-n);
				
			}
		}
		System.out.println(q);
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();;
		q.add(-30);
		q.add(-20);
		q.add(10);
		q.add(60);
		q.add(50);
		q.add(-40);
		q.add(-3);
		q.add(0);
		mystery3(q);
		}


}
