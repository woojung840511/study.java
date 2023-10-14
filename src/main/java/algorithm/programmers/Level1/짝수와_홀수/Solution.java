package algorithm.programmers.Level1.짝수와_홀수;

// https://school.programmers.co.kr/learn/courses/30/lessons/12937
public class Solution {
    public String solution(int num) {
        String answer = "";
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
