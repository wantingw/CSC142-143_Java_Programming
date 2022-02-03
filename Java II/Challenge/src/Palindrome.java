
public class Palindrome {

	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
			return true;
		} else {
			return s.charAt(0) == s.charAt(s.length() - 1) 
					&& isPalindrome(s.substring(1, s.length() - 1));
		}

	}
	
	public static void main (String[] args) {
		System.out.print(isPalindrome("madam"));
		System.out.print(isPalindrome("byebye"));
		System.out.print(isPalindrome("racecar"));
		System.out.print(isPalindrome("rotater"));
		System.out.print(isPalindrome("notion"));
		
	}
}

