package seanboose.ch1_4;

import java.util.Arrays;

/**
 * Problem statement: Write a method to replace all spaces in a string with '%20'. You may assume that the string has
 * sufficient space at the end of the string to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can perform this
 * operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith    ", 13
 * Output:"My%20John%20Smith"
 * 
 * NOTES: The problem says to assume appropriate input, but I chose to implement without that assumption, as mine takes
 * a command line argument.
 */
public class ch1_4{

	/**
	 * Replaces spaces in the input array by indexing the array going from 0 to size. This implementation uses a
	 * copy of the original array to allow this forward search without moving all of the remaining elements of the
	 * array whenever a space is encountered.
	 * @param input char array containing the original string and enough spaces at the end to contain the replacements.
	 * @param size the size of the original String
	 */
	public static void replaceSpacesForward(char[] input, int size){
		char[] copy = Arrays.copyOf(input, input.length);

		int i=0;
		int j=0;
		while(i<size){
			if(copy[i] == ' '){
				input[j] = '%';
				input[j+1] = '2';
				input[j+2] = '0';
				j+=2;
			}
			else input[j] = copy[i];

			++i;
			++j;
		}
	}

	/**
	 * Replaces spaces in input array by indexing from the end of the original string and the full sized array. This is
	 * much more efficient than the forward indexing method and I can't come up with any reason NOT to do this (other
	 * I thought of and implemented the forward method first).
	 * @param input char array containing the original string and enough spaces at the end to contain the replacements.
	 * @param size the size of the original String
	 */
	public static void replaceSpacesBackward(char[] input, int size){
		int i = size-1;
		int j = input.length-1;

		while(i >= 0){
			if(input[i] == ' '){
				input[j] = '0';
				input[j-1] = '2';
				input[j-2] = '%';
				j -= 2;
			}
			else input[j] = input[i];

			--i;
			--j;
		}
	}

	/**
	 * Counts the number of spaces (' ') in a String.
	 * @param s The String to count spaces within.
	 * @return The number of spaces in s.
	 */
	public static int countSpaces(String s){
		int i = 0;
		int count = 0;

		while(i < s.length()) {
			if(s.charAt(i) == ' ') ++count;
			++i;
		}
		return count;
	}

	/**
	 * Generates the appropriate input for the problem from a String containing spaces. The problem requires a char
	 * array that is large enough to contain the string after converting spaces to %20.
	 * @param s The given input string
	 * @return a char[] that is correctly formatted for the problem.
	 */
	public static char[] prepareInput(String s){

		// Determine size of new array
		int len = s.length();
		int spaces = countSpaces(s);
		int newLen = len + 2*spaces;

		// Copy contents of string into char array
		char[] prepared = new char[newLen];
		System.arraycopy(s.toCharArray(), 0, prepared, 0, len);

		// Fill the tail of the array with spaces.
		int fill = len;
		while(fill < newLen){
			prepared[fill] = ' ';
			++fill;
		}

		return prepared;

	}

	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("Please provide a single argument. Use quotation marks to allow spaces (eg \"one two "
				+ "three four\").");
			return;
		}

		char[] inputForward = prepareInput(args[0]);
		char[] inputBackward = Arrays.copyOf(inputForward, inputForward.length);
		int len = args[0].length();

		System.out.println("Input string: \"" + String.valueOf(inputForward) + "\"");

		replaceSpacesForward(inputForward, len);
		replaceSpacesBackward(inputBackward, len);
		String replacedForward = String.valueOf(inputForward);
		String replacedBackward = String.valueOf(inputBackward);

		System.out.println("Ouput string, using forward replacement: \"" + replacedForward + "\"");
		System.out.println("Ouput string, using backward replacement: \"" + replacedBackward + "\"");


	}
}