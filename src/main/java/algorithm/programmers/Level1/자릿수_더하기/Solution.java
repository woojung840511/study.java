package algorithm.programmers.Level1.자릿수_더하기;


public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
            System.out.println("n = " + n);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(123));
    }
}
