import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        test();
    }

    static class Solution {

        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums2.length == 0) {
                return nums1;
            }

            if (nums1.length < nums2.length) {
                int[] temp = nums2;
                nums2 = nums1;
                nums1 = temp;
            }

            Set<Integer> nums2Essentials = new HashSet<>();
            for (int number : nums2) {
                if (0 <= number && number <= 1000) {
                    nums2Essentials.add(number);
                }
            }

            List<Integer> result = new LinkedList<>();
            for (int number : nums1) {
                if (nums2Essentials.contains(number)) {
                    result.add(number);
                    nums2Essentials.remove(number);
                }
            }

            int[] arr = new int[result.size()];
            int index = 0;
            for (int number : result) {
                arr[index++] = number;
            }

            return arr;
        }

    }

    private static void test() {
        final int[][] ar1s = new int[][]{
                new int[]{1},
                new int[]{1},
                new int[]{1},
                new int[]{1, 2},
                new int[]{1, 2, 6},
                new int[]{45, 2, 1},
                new int[]{1, 2, 6, 56, 56, 56, 56},
                new int[]{1, 2, 1, 34, 34, 3, 3, 3, 3, 3, 34}

        };
        final int[][] arr2s = new int[][]{
                new int[]{},
                new int[]{1},
                new int[]{2},
                new int[]{1},
                new int[]{6, 1, 3},
                new int[]{67, 3, 1},
                new int[]{1, 2, 6, 56, 56},
                new int[]{34, 34, 34, 3, 3, 34, 34, 34, 34}

        };
        final int[][] expectations = new int[][]{
                new int[]{1},
                new int[]{1},
                new int[]{},
                new int[]{1},
                new int[]{1, 6},
                new int[]{1},
                new int[]{1, 2, 6, 56},
                new int[]{3, 34}
        };

        for (int i = 0; i < expectations.length; i++) {
            check(ar1s[i], arr2s[i], expectations[i]);
        }

    }

    private static void check(int[] nums1, int[] nums2, int[] expectation) {
        int[] result = new Solution().intersect(nums1, nums2);
        Arrays.sort(result);
        System.out.printf(
                "input ar1: %40s\tintput ar2: %40s\texpectation: %40s\tresult: %40s\t%s\n",
                Arrays.toString(nums1), Arrays.toString(nums2),
                Arrays.toString(expectation),  Arrays.toString(result),
                Arrays.equals(result, expectation) ? "PASSED" : "FAILED"
        );
    }
}
