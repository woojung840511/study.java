package algorithm.programmers.Level1.나누어_떨어지는_숫자_배열;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        int[] temp = new int[arr.length];

        int count = 0;
        for (int i : arr) {
            if (i % divisor == 0) {
                temp[count] = i;
                count++;
            }
        }

        if (count == 0) {
            answer = new int[]{-1};
        } else {
            answer = Arrays.copyOfRange(temp, 0, count);
            Arrays.sort(answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] aa = {3,2,6};
        System.out.println(Arrays.toString(Arrays.copyOfRange(aa, 0, 3)));
        System.out.println(Arrays.toString(new Solution().solution(aa, 5)));
    }
}
