package recursion;

public class ReverseStringRecursive {
	
	public static void main(String[] args) {
		String s = "abcde";
		String reversed = reverse(s);
		System.out.println(reversed);
	}
	
	public static String reverse(String s) {
		if(null != s && s.length() == 1) return s;
		
		return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
	}

}
