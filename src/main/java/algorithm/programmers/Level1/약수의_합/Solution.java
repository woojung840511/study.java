package algorithm.programmers.Level1.약수의_합;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 0;

        while (++i <= n) {
            answer += (n % i == 0 ? i : 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(12));
    }
}
