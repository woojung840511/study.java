package algorithm.leetCode;

import java.util.Arrays;

public class _4_Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        new _4_Median_of_Two_Sorted_Arrays().findMedianSortedArrays(
            nums1, nums2
        );
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        Arrays.sort(mergedArray);
        boolean isLengthOdd = mergedArray.length % 2  == 1;

        if (isLengthOdd) {
            return mergedArray[mergedArray.length / 2 ];
        } else {
            int first = mergedArray[mergedArray.length / 2 - 1];
            int second = mergedArray[mergedArray.length / 2 ];
            return (first + second) / (double) 2;
        }

    }
}
