package algorithm.programmers.Level1.자연수_뒤집어_배열로_만들기;

public class Solution {
    public int[] solution(long n) {
        int[] answer;

        String numStr = String.valueOf(n);
        int length = numStr.length();
        answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = Integer.parseInt(
                    numStr.substring(length - i - 1, length - i)
            );
        }

        return answer;
    }
}
