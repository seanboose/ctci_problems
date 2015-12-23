package ch1_1;

public class UniqueCharString{
	private String mString;

	public UniqueCharString(String input){
		mString = input;
	}

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