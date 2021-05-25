import java.util.Arrays;

public class MinimumValueToGetPositiveStepByStepSum {

    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public int minStartValue(int[] nums) {
            int startValue = 1;
            int currentValue = startValue;
            for (int number : nums) {
                currentValue += number;
                if (currentValue < 1) {
                    int difference = 1 - currentValue;
                    startValue += difference;
                    currentValue += difference;
                }
            }
            return startValue;
        }

    }

    private static void test() {
        final int[][] inputs = new int[][]{
                new int[]{-3,2,-3,4,2},
                new int[]{1,2},
                new int[]{1,-2,-3}
        };
        final int[] expectations = new int[]{
                5,
                1,
                5
        };

        for (int i = 0; i < expectations.length; i++) {
            check(inputs[i], expectations[i]);
        }

    }

    private static void check(int[] nums, int expectation) {
        int result = new Solution().minStartValue(nums);
        System.out.printf(
                "input nums: %30s\texpectation: %30s\tresult: %30s\t%s\n",
                Arrays.toString(nums), expectation,  result,
                result == expectation ? "PASSED" : "FAILED"
        );
    }
}
