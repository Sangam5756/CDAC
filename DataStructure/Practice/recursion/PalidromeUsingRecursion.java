package recursion;

public class PalidromeUsingRecursion {

	public static void main(String[] args) {
		String str = "nitins";
		System.out.println("Is it a palindrome : " + isPalindrome(str, 0, str.length() - 1));
	}

	public static boolean isPalindrome(String str, int left, int right) {
		if (left >= right)
			return true;
		if (null != str && str.charAt(left) != str.charAt(right))
			return false;
		return isPalindrome(str, left + 1, right - 1);
	}

}
