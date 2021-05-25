import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

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

            Map<Integer, Integer> nums2Essentials = new HashMap<>();
            for (int number : nums2) {
                if (0 <= number && number <= 1000) {
                    nums2Essentials.compute(number, (key, value) -> value == null ? 1 : value + 1);
                }
            }

            List<Integer> result = new LinkedList<>();
            for (int number : nums1) {
                nums2Essentials.computeIfPresent(number, (key, value) -> {
                    result.add(key);
                    return value == 1 ? null : value - 1;
                });
            }

            int[] arr = new int[result.size()];
            int index = 0;
            for (int number : result) {
                arr[index++] = number;
            }

            return arr;
        }

//        public int[] intersect(int[] nums1, int[] nums2) {
//            if (nums2.length == 0) {
//                return nums1;
//            }
//
//            if (nums1.length < nums2.length) {
//                int[] temp = nums2;
//                nums2 = nums1;
//                nums1 = temp;
//            }
//
//            Map<Integer, Integer> nums2Essentials = new HashMap<>();
//            for (int number : nums2) {
//                if (0 <= number && number <= 1000) {
//                    nums2Essentials.compute(number, (key, value) -> value == null ? 1 : value + 1);
//                }
//            }
//
//            List<Integer> result = new LinkedList<>();
//            for (int number : nums1) {
//                nums2Essentials.computeIfPresent(number, (key, value) -> {
//                    result.add(key);
//                    return value == 1 ? null : value - 1;
//                });
//            }
//
//            return result.stream().mapToInt(i -> i).toArray();
//        }


//        public int[] intersect(int[] nums1, int[] nums2) {
//            if (nums2.length == 0) {
//                return nums1;
//            }
//
//            int[] intermediate1 = new int[1001];
//            for (int i : nums1) {
//                if (0 <= i && i <= 1000) {
//                    intermediate1[i]++;
//                }
//            }
//
//            int[] intermediate2 = new int[1001];
//            for (int i : nums2) {
//                if (0 <= i && i <= 1000) {
//                    intermediate2[i]++;
//                }
//            }
//
//            List<Integer> result = new LinkedList<>();
//            for (int i = 0; i < intermediate1.length; i++) {
//                int numberOfMatches = Math.min(intermediate1[i], intermediate2[i]);
//                for (; numberOfMatches > 0; numberOfMatches--) {
//                    result.add(i);
//                }
//            }
//
//            return result.stream().mapToInt(i -> i).toArray();
//        }


////        public int[] intersect2(int[] nums1, int[] nums2) {
////            if (nums2.length == 0) {
////                return nums1;
////            }
////
////            int[] ar1;
////            int[] ar2;
////            if (nums1.length > nums2.length) {
////                ar1 = nums1;
////                ar2 = nums2;
////            } else {
////                ar2 = nums1;
////                ar1 = nums2;
////            }
////
////            List<Integer> result = new LinkedList<>();
////            Map<Integer, LinkedList<Integer>> utility = new HashMap<>(ar2.length);
////            for (int i : ar2) {
////                if (0 <= i && i <= 1000 ) {
////                    utility.compute(i, (number, list) -> {
////                        if (list == null) {
////                            list = new LinkedList<>();
////                            list.add(number);
////                            return list;
////                        }
////                        list.add(number);
////                        return list;
////                    });
////                }
////            }
//
//            for (int number : ar1) {
//                if (utility.containsKey(number)) {
//                    final List<Integer> value = utility.get(number);
//                    result.add(number);
//                    value.remove(0);
//                    if (value.size() == 0) {
//                        utility.remove(number);
//                    }
//                }
//            }
//
//            return result.stream().mapToInt(i -> i).toArray();
//        }

        
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
                new int[]{1, 2, 6, 56, 56},
                new int[]{3, 3, 34, 34, 34}
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
