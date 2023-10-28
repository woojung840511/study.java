package algorithm.programmers.Level1.가운데_글자_가져오기;

public class Solution {
    public String solution(String s) {
        int length = s.length();
        int beginIndex = length / 2;
        return length % 2 == 0 ?
                s.substring(beginIndex - 1, beginIndex + 1) :
                s.substring(beginIndex, beginIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution("abcde")
        );

        System.out.println(
                new Solution().solution("qwer")
        );
    }
}
