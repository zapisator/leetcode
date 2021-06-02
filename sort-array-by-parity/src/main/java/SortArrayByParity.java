import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        final int[] preperings = new int[nums.length * 5];
        int nonNegative = nums.length;
        int negative = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 1) {
                preperings[nonNegative++] = num;
            } else {
                preperings[negative--] = num;
            }
        }
        return Arrays.copyOfRange(preperings, negative + 1, nonNegative);
    }


//    public int[] sortArrayByParity(int[] nums) {
//        final LinkedList<Integer> result = new LinkedList<>();
//
//        for (int num : nums) {
//            if (num % 2 == 0) {
//                result.addFirst(num);
//            } else {
//                result.addLast(num);
//            }
//        }
//        return result.stream().mapToInt(i -> i).toArray();
//    }

}
