package algorithm.programmers.Level1.x만큼_간격이_있는_n개의_숫자;

import java.util.Arrays;

public class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(-4, 2)));
    }
}
