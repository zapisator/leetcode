import java.util.List;

public class BuddyStrings {
    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public boolean buddyStrings(String a, String b){
            char[] ar1 = a.toCharArray();
            char[] ar2 = b.toCharArray();
            int[] resultIndices = new int[2];
            int resultIndex = -1;

            if (ar1.length != ar2.length) {
                return false;
            }

            for(int i = 0; i < ar1.length; i++) {
                if (ar1[i] != ar2[i]) {
                    resultIndex++;
                    if (resultIndex > 1) {
                        return false;
                    }
                    resultIndices[resultIndex] = i;
                }
            }

            if (resultIndex == 0) {
                return false;
            } else if (resultIndex == -1) {
                if (ar1.length > 'z' - 'a' + 1) {
                    return true;
                }
                int[] coutRepeated = new int['z' - 'a' + 1];
                for (int number : ar1) {
                    coutRepeated[number - 'a']++;
                    if (coutRepeated[number - 'a'] == 2) {
                        return true;
                    }
                }
                return false;
            }

            return ar1[resultIndices[0]] == ar2[resultIndices[1]]
                    && ar1[resultIndices[1]] == ar2[resultIndices[0]];
        }

    }

    private static void test() {
        final List<String> leftStrings = List.of(
                "ab",
                "ab",
                "aa",
                "aaaaaaabc",
                "ab"
        );
        final List<String> rightStrings = List.of(
                "ba",
                "ab",
                "aa",
                "aaaaaaacb",
                "babbb"
        );
        final List<Boolean> expectations = List.of(
                true,
                false,
                true,
                true,
                false
        );

        for (int i = 0; i < expectations.size(); i++) {
            check(leftStrings.get(i), rightStrings.get(i), expectations.get(i));
        }

    }

    private static void check(String leftString, String rightString, boolean expectation) {
        boolean result = new Solution().buddyStrings(leftString, rightString);
        System.out.printf(
                "input leftString: %30s\t||\tinput rightString: %30s\t||\texpectation: %8s\t||\tresult: %8s\t||\t%s\n",
                leftString, rightString,  expectation, result,
                result == expectation ? "PASSED" : "FAILED"
        );
    }
}
