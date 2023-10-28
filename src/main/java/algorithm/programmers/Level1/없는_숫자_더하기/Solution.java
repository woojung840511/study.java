package algorithm.programmers.Level1.없는_숫자_더하기;

import java.util.Arrays;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            answer += !Arrays.stream(numbers).anyMatch(n -> n == finalI) ? finalI : 0;
        }
        return answer;
    }
}
