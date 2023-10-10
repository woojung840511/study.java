package algorithm.leetCode;

public class _1_Two_Sum { // Accepted 그렇지만 복습해야함

    public int[] twoSum(int[] nums, int target) {
        int[] answerArray = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];

            boolean hasArray = false;
            for (int j = i + 1; j < nums.length; j++) {
                int n2 = nums[j];

                if (n1 + n2 == target) {
                    answerArray[0] = i;
                    answerArray[1] = j;
                    hasArray = true;
                    break;
                }
            }

            if (hasArray) {
                break;
            }
        }

        return answerArray;
    }
}
