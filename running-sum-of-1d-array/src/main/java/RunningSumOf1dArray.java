import java.util.Arrays;

public class RunningSumOf1dArray {

    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public int[] runningSum(int[] nums) {
            int[] result = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                result[i] = sum;
            }
            return result;
        }

    }

    private static void test() {
        final int[][] inputs = new int[][]{
                new int[]{1},
                new int[]{1, 3},
                new int[]{1, 2, 5},
                new int[]{1, 2, 6, 1},
                new int[]{45, 2, 1, 2, 2},
                new int[]{1, 2, 6, 56, 2, -56},
                new int[]{1, 2, 1, 34, -34, 3, -3, -3}

        };
        final int[][] expectations = new int[][]{
                new int[]{1},
                new int[]{1, 4},
                new int[]{1, 3, 8},
                new int[]{1, 3, 9, 10},
                new int[]{45, 47, 48, 50, 52},
                new int[]{1, 3, 9, 65, 67, 11},
                new int[]{1, 3, 4, 38, 4, 7, 4, 1}
        };

        for (int i = 0; i < expectations.length; i++) {
            check(inputs[i], expectations[i]);
        }

    }

    private static void check(int[] nums, int[] expectation) {
        int[] result = new Solution().runningSum(nums);
        System.out.printf(
                "input nums: %30s\texpectation: %30s\tresult: %30s\t%s\n",
                Arrays.toString(nums), Arrays.toString(expectation),  Arrays.toString(result),
                Arrays.equals(result, expectation) ? "PASSED" : "FAILED"
        );
    }
}
