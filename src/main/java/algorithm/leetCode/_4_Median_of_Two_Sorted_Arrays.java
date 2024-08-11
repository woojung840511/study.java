package algorithm.leetCode;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _4_Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        String str = "보장보험료(290,000원) 은 오소리 고양이 뚜뚜 보장보험료 [2200]원";
        Matcher matcher = Pattern.compile("보장보험료.*?원").matcher(str);

        System.out.println(matcher.group());
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
