import java.util.Arrays;
import java.util.List;

public class ShuffleString {

    public static void main(String[] args) {
        test();
    }

    static class Solution {
        public String restoreString(String s, int[] indices) {
            char[] str = s.toCharArray();
            char[] ar = new char[str.length];
            for (int i = 0; i < str.length; i++) {
                ar[indices[i]] = str[i];
            }
            return String.valueOf(ar);
        }
    }

    private static void test() {
        final List<String> ss = List.of(
            "codeleet"
        );
        final int[][] indicesAr = new int[][]{
                new int[]{4,5,6,7,0,2,1,3}
        };

        for (int i = 0; i < ss.size(); i++) {
            check(ss.get(i), indicesAr[i], "leetcode");
        }

    }

    private static void check(String s, int[] indices, String expectation) {
        final String result = new Solution().restoreString(s, indices);
        System.out.printf(
                "input string: %10s\tindices: %10s\texpectation: %10s\tresult: %10s\t%s",
                s, Arrays.toString(indices), expectation,  result, result.equals(expectation) ? "PASSED" : "FAILED"
                );
    }

}
