import java.util.List;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public boolean areAlmostEqual(String s1, String s2){
            char[] ar1 = s1.toCharArray();
            char[] ar2 = s2.toCharArray();
            int[] resultIndices = new int[2];
            int resultIndex = -1;

            for(int i = 0; i < ar1.length; i++) {
                if (ar1[i] != ar2[i]) {
                    resultIndex++;
                    if (resultIndex > 1) {
                        return false;
                    }
                    resultIndices[resultIndex] = i;
                }
            }

            if (resultIndex == -1) {
                return true;
            } else if (resultIndex == 0) {
                return false;
            }

            return ar1[resultIndices[0]] == ar2[resultIndices[1]]
                    && ar1[resultIndices[1]] == ar2[resultIndices[0]];
        }

    }

    private static void test() {
        final List<String> leftStrings = List.of(
                "bank",
                "attack",
                "kelb",
                "abcd"

        );
        final List<String> rightStrings = List.of(
                "kanb",
                "defend",
                "kelb",
                "dcba"
        );
        final List<Boolean> expectations = List.of(
                true,
                false,
                true,
                false
        );

        for (int i = 0; i < expectations.size(); i++) {
            check(leftStrings.get(i), rightStrings.get(i), expectations.get(i));
        }

    }

    private static void check(String leftString, String rightString, boolean expectation) {
        boolean result = new Solution().areAlmostEqual(leftString, rightString);
        System.out.printf(
                "input leftString: %30s\tinput rightString: %30s\texpectation: %8s\tresult: %8s\t%s\n",
                leftString, rightString,  expectation, result,
                result == expectation ? "PASSED" : "FAILED"
        );
    }
}
