package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome main = new ValidPalindrome();
        List<String> arr = new ArrayList<>(Arrays.asList("oso", "Anilina", "reconocer"));
        long start = System.currentTimeMillis(); // Start time
        arr.forEach(s -> {
            System.out.println(main.isPalindromeV2(s));
        });
        long end = System.currentTimeMillis();   // End time
        long executionTime = end - start;

        System.out.println("Execution time: " + executionTime + " ms");
    }

    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s", "").toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeV2(String str) {
        str = str.replaceAll("\\s", "").toLowerCase();

        int length = str.length();

        String finalStr = str;
        return IntStream.range(0, length / 2)
                .allMatch(i -> finalStr.charAt(i) == finalStr.charAt(length - i - 1));
    }

    public boolean isPalindromeV3(String str) {
        str = str.replaceAll("\\s", "").toLowerCase();

        int length = str.length() - 1;

        String finalStr = str;
        return IntStream.range(0, length / 2)
                .allMatch(i -> finalStr.charAt(i) == finalStr.charAt(length - i));
    }
}
