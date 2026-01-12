package problems;

import java.util.stream.IntStream;

public class ConcatenationOfArray {

    public static void main(String[] args) {
        ConcatenationOfArray main = new ConcatenationOfArray();
    }

    public int[] getConcatenation1(int[] nums) {
        int[] result = new int[nums.length * 2];
        System.arraycopy(nums, 0, result, 0, nums.length);
        System.arraycopy(nums, 0, result, nums.length, nums.length);
        return result;
    }

    public int[] getConcatenation2(int[] nums) {
        int[] result = new int[nums.length * 2];
        int k = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < nums.length; j++){
                result[k++] = nums[j];
            }
        }
        return result;
    }

    public int[] getConcatenation3(int[] nums) {
        return IntStream.concat(IntStream.of(nums), IntStream.of(nums))
                .toArray();
    }

}
