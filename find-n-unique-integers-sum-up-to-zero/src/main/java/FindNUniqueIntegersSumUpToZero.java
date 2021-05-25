import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public int[] sumZero(int n){
            int[] result = new int[n];
            int value = -(result.length / 2);
            int i = 0;

            for (; i < result.length / 2; i++) {
                result[i] = value++;
            }
            if (result.length % 2 == 0) {
                value++;
            }
            for (; i < result.length; i++) {
                result[i] = value++;
            }
            return result;
        }

    }

    private static void test() {
        final int[] inputs = new int[]{
                1,
                2,
                3,
                4,
                5,
                6,
                7
        };
        final int[][] expectations = new int[][]{
                new int[]{0},
                new int[]{-1, 1},
                new int[]{-1, 0, 1},
                new int[]{-2, -1, 1, 2},
                new int[]{-2, -1, 0, 1, 2},
                new int[]{-3, -2, -1, 1, 2, 3},
                new int[]{-3, -2, -1, 0, 1, 2, 3},
        };

        for (int i = 0; i < expectations.length; i++) {
            check(inputs[i], expectations[i]);
        }

    }

    private static void check(int nums, int[] expectation) {
        int[] result = new Solution().sumZero(nums);
        System.out.printf(
                "input nums: %30s\texpectation: %30s\tresult: %30s\t%s\n",
                nums, Arrays.toString(expectation),  Arrays.toString(result),
                Arrays.equals(result, expectation) ? "PASSED" : "FAILED"
        );
    }
}
