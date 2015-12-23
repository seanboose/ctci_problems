package seanboose.ch1_3;

import java.util.Arrays;

public class StringPermutationChecker{
	String mS1;
	String mS2;

	/**
	 * Create an object used to check if two strings are permutations of each other.
	 * @param s1 The first String to be checked.
	 * @param s2 the second String to be checked.
	 */
	public StringPermutationChecker(String s1, String s2){
		mS1 = s1;
		mS2 = s2;
	}

	/**
	 * Returns true if this object's Strings are permutations of each other. Uses sorted char[] implementation, O(nlogn).
	 * @return true if Strings are permutations, false otherwise.
	 */
	public boolean arePermutationsSorted(){
		if(mS1.length() != mS2.length()) return false;

		// Create sorted arrays representing the chars in each String
		char[] chars1 = mS1.toCharArray();
		char[] chars2 = mS2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);

		// After sorting, any mistmatch represents differing characters in the original Strings
		int end = chars1.length;
		int i = 0;
		while(i<end){
			if(chars1[i] != chars2[i]) return false;
			++i;
		}
		return true;
	}

	/**
	 * Returns true if this object's Strings are permutations of each other. Uses char counting implementation, O(n).
	 * Assumes all ASCII charset.
	 * @return true if Strings are permutations, false otherwise.
	 */
	public boolean arePermutationsCounted(){
		if(mS1.length() != mS2.length()) return false;

		// Contains counts of all chars in the Strings
		int[] counts1 = new int[128];
		int[] counts2 = new int[128];

		for(int i=0; i< mS1.length(); ++i){
			++counts1[mS1.charAt(i)];
			++counts2[mS2.charAt(i)];
		}

		int i=0;
		while(i<128){
			if(counts1[i] != counts2[i]) return false;
			++i;
		}

		return true;
	}
}