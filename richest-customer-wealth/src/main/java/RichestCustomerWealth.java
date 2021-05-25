import java.util.Arrays;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public int maximumWealth(int[][] accounts)  {
            int maximumWealth = 0;
            for (int[] account : accounts) {
                maximumWealth = Math.max(maximumWealth, arraySum(account));
            }
            return maximumWealth;
        }

        private int arraySum(int[] array) {
            int sum = 0;
            for (int number : array) {
                sum += number;
            }
            return sum;
        }

    }

    private static void test() {
        final int[][] accounts1 = new int[][]{
                new int[]{1}
        };
        final int[][] accounts2 = new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 2, 1},
        };
        final int[][][] accountBank = new int[][][]{accounts1, accounts2};
        final int[] expectations = new int[]{
                1,
                6
        };

        for (int i = 0; i < expectations.length; i++) {
            check(accountBank[i], expectations[i]);
        }

    }

    private static void check(int[][] accounts, int expectation) {
        int result = new Solution().maximumWealth(accounts);
        System.out.printf(
                "input accounts: %30s\texpectation: %30s\tresult: %30s\t%s\n",
                Arrays.deepToString(accounts),  expectation, result,
                result == expectation ? "PASSED" : "FAILED"
        );
    }
}
