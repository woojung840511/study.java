package algorithm.programmers.Level1.수박수박수박수박수박수;

public class Solution {
    public String solution(int n) {
        String str = "수박";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i % str.length());
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(4)
        );

        System.out.println(
                new Solution().solution(3)
        );

    }
}
