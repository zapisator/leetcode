public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        RadixSort.radixSort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i +=2 ) {
            sum += nums[i];
        }
        return sum;
    }
}
/*
* sorting algorithm implementation was taken form https://github.com/lemire/Code-used-on-Daniel-Lemire-s-blog/blob/master/2021/04/09/src/main/java/me/lemire/microbenchmarks/algorithms/RadixSort.java
* */
class RadixSort {

    public static void radixSort(int[] data) {
        int[] copy = new int[data.length];
        int[] level0 = new int[257];
        int[] level1 = new int[257];
        int[] level2 = new int[257];
        int[] level3 = new int[257];
        for (int value : data) {
            value -= Integer.MIN_VALUE;
            level0[(value & 0xFF) + 1] ++;
            level1[((value >>> 8) & 0xFF) + 1] ++;
            level2[((value >>> 16) & 0xFF) + 1] ++;
            level3[((value >>> 24) & 0xFF) + 1] ++;
        }
        for (int i = 1; i < level0.length; ++i) {
            level0[i] += level0[i - 1];
            level1[i] += level1[i - 1];
            level2[i] += level2[i - 1];
            level3[i] += level3[i - 1];
        }
        for (int value : data) {
            copy[level0[(value - Integer.MIN_VALUE) & 0xFF]++] = value;
        }
        for (int value : copy) {
            data[level1[((value - Integer.MIN_VALUE)>>>8) & 0xFF]++] = value;
        }
        for (int value : data) {
            copy[level2[((value - Integer.MIN_VALUE)>>>16) & 0xFF]++] = value;
        }
        for (int value : copy) {
            data[level3[((value - Integer.MIN_VALUE)>>>24) & 0xFF]++] = value;
        }
    }
}
