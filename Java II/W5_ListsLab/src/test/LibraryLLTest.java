package test;

import java.util.LinkedList;

public class LibraryLLTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		list.add("Amy");
		list.add("Sam");
		list.add("Jim");
		list.add("Tim");
		System.out.println(list.isEmpty());
		System.out.println("Size Before: " + list.size());
		System.out.println(list);
		System.out.println("Deleted Item: " + list.remove(1));
		System.out.println("Size After: " + list.size());
		System.out.println(list);
		

	}

}
