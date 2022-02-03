package explain;

import java.util.ArrayList;


public class TestMyList {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(list.size());
		list.add("Tom");
		list.add("Sam");
		list.add("Jim");
		list.add("Tim");
		System.out.println("Size Before" + list.size());
		System.out.println(list);
		System.out.println("Deleted Item: " + list.remove(1));
		System.out.println(list.size());
		System.out.println("Size After: " + list);
	}
}
