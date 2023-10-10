package algorithm.programmers.Level1;

public class 문자열_다루기_기본 {

    public boolean solution(String s) {
        boolean answer = false;

        if (s.length() == 4 || s.length() == 6) {
            if (s.matches("^[0-9]+$")) answer = true;
        }
        return answer;
    }

    public static void main(String[] args) {
        new 문자열_다루기_기본().solution("1234");
    }
}
