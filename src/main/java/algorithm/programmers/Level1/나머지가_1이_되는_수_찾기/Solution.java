package algorithm.programmers.Level1.나머지가_1이_되는_수_찾기;

public class Solution {
    public int solution(int n) {
        int answer = 1;
/*        while (n % answer != 1) {
            answer++;
        }*/
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(10));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution().solution(10));
//    }
}
