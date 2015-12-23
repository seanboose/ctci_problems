package seanboose.ch1_2;

/**
 * Problem statement: Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.
 * Note: I'll be doing this in Java to refresh myself on how Java handles Strings. C++ version would be simple.
 */
public class ch1_2{

	/**
	 * Takes a char[] and reverses it in place. Cannot use String for this function in Java because Java uses purely
	 * pass-by-value semantics and Strings are immutable (so passing a String and assigning it something new would not 
	 * affect the passer String, while modifying the String would generate an error). Could have also used a
	 * StringBuilder object, but since length of the String will not change, this seemed unnecessary.
	 * @param char[] char array containing the characters of the String to be reversed.
	 */
	private static void reverseString(char[] s){
		int len = s.length;

		for(int i=0; i<len/2; ++i){
			char t = s[i];
			s[i] = s[len-1-i];
			s[len-1-i] = t;
		}
	}

	/**
	 * Takes any number of string arguments (greater than 0) and outputs their reversed forms.
	 * @param args The strings to be reversed.
	 */
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("Please provide at least one string to reverse.");
			return;
		}

		for(String s : args){
			System.out.println("Input string: " + s);
			char[] c = s.toCharArray();
			reverseString(c);
			System.out.println("Reversed string: " + String.valueOf(c));
		}
	}
}