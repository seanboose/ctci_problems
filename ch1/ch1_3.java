package seanboose.ch1_3;

/**
 * Problem statement: Given two strings, write a method to decide if one is a permutation of the other.
 */
public class ch1_3{
	public static void main(String[] args){
		if(args.length != 2){
			System.out.println("Please provide two arguments.");
			return;
		}

		StringPermutationChecker check = new StringPermutationChecker(args[0], args[1]);
		System.out.println("Args are permutations of each other: ");
		System.out.println("    Sorting method: " + check.arePermutationsSorted());
		System.out.println("    Counting method: " + check.arePermutationsCounted());
	}
}