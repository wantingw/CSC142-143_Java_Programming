import java.util.ArrayList;
public class Pratice4 {
	
	public int keyWordCount(ArrayList<String> a, String w) {
		
		int counter=0;
		int index = 0;
		for (int i = 0; i < a.size(); i++) {
			String s= a.get(i);
			while(index!=-1) {
				index = s.indexOf(w,index);
				if(index!=-1) {
					counter++;
					index++;
				}
			}
			index = 0;
		}	
		return counter;
		
	}
	
public static void main (String[] args) {
	Pratice4 p = new Pratice4();
	ArrayList<String> abc= new ArrayList<String>();
	abc.add("The classification of cats");
	abc.add("staccato");
	abc.add("catamaran");
	abc.add("the caterpillar and the bobcat");
	System.out.println(abc);
	System.out.println(p.keyWordCount(abc, "cat"));
}
}