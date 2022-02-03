package test;

import java.util.ArrayList;
import utility.List;

public class LibraryTest {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		System.out.println(list.size());
		list.add("Amy");
		list.add("Sam");
		list.add("Jim");
		list.add("Tim");
		System.out.println("Size Before: " + list.size());
		System.out.println(list);
		System.out.println("Deleted Item: " + list.remove(1));
		System.out.println("Size After: " + list.size());
		System.out.println(list);
		System.out.println("");
		list.add(2, "Tom");
		System.out.println(list);
		System.out.println(list.get(2));
		list.set(2, "Sam");
		System.out.println(list);
		list.clear();
		System.out.println(list);
		System.out.println(list.isEmpty());
	}
}