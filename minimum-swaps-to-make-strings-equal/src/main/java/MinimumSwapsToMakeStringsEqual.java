import java.util.Arrays;
import java.util.List;

public class MinimumSwapsToMakeStringsEqual {
    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public int minimumSwap(String s1, String s2) {
            char[] ar1 = s1.toCharArray();
            char[] ar2 = s2.toCharArray();
            int numberOfMismatches = 0;
            int numberOfXAtMismatches = 0;

            if (ar1.length != ar2.length) {
                return -1;
            } else if (ar1.length == 0) {
                return 0;
            }

            for(int i = 0; i < ar1.length; i++) {
                if (ar1[i] != ar2[i]) {
                    numberOfMismatches++;
                    if (ar1[i] == 'x') {
                        numberOfXAtMismatches++;
                    }
                };
            }

            if (numberOfMismatches % 2 != 0) {
                return -1;
            }

            return numberOfXAtMismatches % 2 + numberOfMismatches / 2;
        }

    }

    private static void test() {
        final List<String> leftStrings = List.of(
                "xx",
                "xy",
                "xx",
                "xxyyxyxyxx"
        );
        final List<String> rightStrings = List.of(
                "yy",
                "yx",
                "xy",
                "xyyxyxxxyx"
        );
        final List<Integer> expectations = List.of(
                1,
                2,
                -1,
                4
        );

        for (int i = 0; i < expectations.size(); i++) {
            check(leftStrings.get(i), rightStrings.get(i), expectations.get(i));
        }

    }

    private static void check(String s1, String s2, int expectation) {
        int result = new Solution().minimumSwap(s1, s2);
        System.out.printf(
                "input s1: %30s\t||\tinput s2: %30s\t||\texpectation: %8s\t||\tresult: %8s\t||\t%s\n",
                s1, s2,  expectation, result,
                result == expectation ? "PASSED" : "FAILED"
        );
    }
}
