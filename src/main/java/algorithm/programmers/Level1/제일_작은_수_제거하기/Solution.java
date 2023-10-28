package algorithm.programmers.Level1.제일_작은_수_제거하기;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int[] arr) {
        int min = IntStream.of(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(i -> i != min).toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution().solution(new int[]{4,3,2,1}
                )));

        System.out.println(Arrays.toString(
                new Solution().solution(new int[]{10}
                )));
    }

}
