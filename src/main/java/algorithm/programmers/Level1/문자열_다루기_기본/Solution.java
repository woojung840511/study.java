package algorithm.programmers.Level1.문자열_다루기_기본;

class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && (s.matches("^[0-9]+$"));
    }
}
