package problems;

import java.util.ArrayList;
import java.util.List;

/*
	write a method to identify if a string has any character repetation

 	Example:

		checkRepeatedChar("alpha") returns true (has repeat character)
		checkRepeatedChar("beta") returns false (no repeat character)
*/

public class CheckRepeatedChar {
	
	public static void main(String[] args) {
		CheckRepeatedChar main = new CheckRepeatedChar();
		System.out.println(main.checkRepeatedChar("beta"));
	}
	
	public boolean checkRepeatedChar(String word) {
		boolean isRepeated = false;
		List<Character> characters = new ArrayList<Character>();
		for(char character : word.toCharArray()) {
			if(characters.contains(character)) {
				isRepeated = true;
				break;
			}
			characters.add(character);
		}
		return isRepeated;
	}
}
