import java.util.Arrays;
import java.util.List;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public boolean closeStrings(String word1, String word2){
            char[] ar1 = word1.toCharArray();
            char[] ar2 = word2.toCharArray();
            int[] word1chars = new int['z' - 'a' + 1];
            int[] word2chars = new int['z' - 'a' + 1];

            if (ar1.length != ar2.length) {
                return false;
            } else if (ar1.length == 0) {
                return true;
            }

            for(int i = 0; i < ar1.length; i++) {
                word1chars[ar1[i] - 'a']++;
                word2chars[ar2[i] - 'a']++;
            }

            for (int i = 0; i < word1chars.length; i++) {
                if (word1chars[i] > 0 && word2chars[i] == 0 || word1chars[i] == 0 && word2chars[i] > 0) {
                    return false;
                }
            }

            Arrays.sort(word1chars);
            Arrays.sort(word2chars);
            return Arrays.equals(word1chars, word2chars);
        }

    }

    private static void test() {
        final List<String> leftStrings = List.of(
                "abc",
                "a",
                "cabbba",
                "cabbba",
                "uau"
        );
        final List<String> rightStrings = List.of(
                "bca",
                "aa",
                "abbccc",
                "aabbss",
                "ssx"
        );
        final List<Boolean> expectations = List.of(
                true,
                false,
                true,
                false,
                false
        );

        for (int i = 0; i < expectations.size(); i++) {
            check(leftStrings.get(i), rightStrings.get(i), expectations.get(i));
        }

    }

    private static void check(String word1, String word2, boolean expectation) {
        boolean result = new Solution().closeStrings(word1, word2);
        System.out.printf(
                "input word1: %30s\t||\tinput word2: %30s\t||\texpectation: %8s\t||\tresult: %8s\t||\t%s\n",
                word1, word2,  expectation, result,
                result == expectation ? "PASSED" : "FAILED"
        );
    }
}
