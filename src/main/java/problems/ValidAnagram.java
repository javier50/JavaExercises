package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidAnagram {
	
	public static void main(String[] args) {
		ValidAnagram main = new ValidAnagram();
		System.out.println(main.isAnagram("anagram", "nagaram"));
		System.out.println(main.isAnagram("rat", "car"));
		System.out.println(main.isAnagram("qwe", "ewq"));
		System.out.println(main.isAnagram("qweu", "ewqr"));
	}

	public boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		List<String> sL = new ArrayList<>(Arrays.asList(str1.split("")));
		List<String> tL = new ArrayList<>(Arrays.asList(str2.split("")));

		for(String c : sL){
			if(tL.contains(c)){
				tL.remove(tL.indexOf(c));
			}
		}

		return (tL.size() == 0);
	}
}
