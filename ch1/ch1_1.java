package seanboose.ch1_1;

/**
 * Problem statement: Implement an algorithm to determine if a string has all unique characters. What if you cannot use
 * additional data structures?
 */
public class ch1_1{

	/**
	 * Determines if a given string has only uique characters using two different methods.
	 * @param args A single string to check
	 */
	public static void main(String[] args){

		if(args.length != 1){
			System.out.println("Please provide a single argument.");
			return;
		}

		String input = args[0];
		UniqueCharString uniqueString = new UniqueCharString(input);

		System.out.println("Input string \"" + input + "\" has only unique chars:");
		System.out.println("    Array method, O(n): " + uniqueString.hasUniqueCharsArray());
		System.out.println("    Brute force method, O(n^2): " + uniqueString.hasUniqueCharsBrute());
	}
}