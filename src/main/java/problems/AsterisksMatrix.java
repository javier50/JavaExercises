package problems;

import java.util.Arrays;

public class AsterisksMatrix {
    public static void main(String args[]) {
        String[] picture = {"abc","ded"};
        Arrays.stream(solution(picture)).forEach(System.out::println);
    }

    public static String[] solution(String[] picture) {
        String[] pictureBorder = new String[picture.length + 2];

        for(int i = 0 ; i < picture.length ; i++) {
            pictureBorder[i+1] = String.format("*%s*", picture[i]);
        }
        pictureBorder[0] = pictureBorder[pictureBorder.length-1] = pictureBorder[1].replaceAll(".","*");

        return pictureBorder;
    }
}
