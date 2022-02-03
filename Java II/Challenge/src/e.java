
public class e {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println(count("Wlllcom",'l'));
	}public static int count(String str, char letter) {int ct = 0; if (str.length() > 0) {if (str.charAt(0) == letter) {ct++;}return ct + count(str.substring(1), letter);}return ct;}
}
	

