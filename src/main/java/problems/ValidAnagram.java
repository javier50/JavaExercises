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

        for (String c : sL) {
            if (tL.contains(c)) {
                tL.remove(tL.indexOf(c));
            }
        }

        return (tL.size() == 0);
    }

    public boolean isAnagramV2(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
