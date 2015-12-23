package seanboose.ch1_1;


/**
 * Class used to determine if all of the characters in a provided string are unique.
 */
public class UniqueCharString{
	private String mString;

	/**
	 * Create a UniqueCharString object for a provided string.
	 * @param String to be checked for unique chars
	 */
	public UniqueCharString(String input){
		mString = input;
	}

	/** 
	 * Determines if this object's string has only unique character useing an O(n) implementation.
	 * @return true if all chars are unique, false otherwise.
	 */
	public boolean hasUniqueCharsArray(){
		int[] charsChecked = new int[128];
		for(int i=0; i<mString.length(); ++i){
			char c = mString.charAt(i);

			// Haven't encountered this char before
			if(charsChecked[c] == 0){
				++charsChecked[c];
			}
			// This char has been encountered
			else return false;
		}
		return true;
	}

	/** 
	 * Determines if this object's string has only unique character useing an O(n^2) implementation.
	 * @return true if all chars are unique, false otherwise.
	 */
	public boolean hasUniqueCharsBrute(){

		for(int i=0; i<mString.length(); ++i){
			char iChar = mString.charAt(i);

			for(int j=i+1; j<mString.length(); ++j){
				if(iChar == mString.charAt(j)) return false;
			}
		}
		return true;
	}
}