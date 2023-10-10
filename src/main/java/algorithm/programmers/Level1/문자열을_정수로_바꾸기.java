package algorithm.programmers.Level1;

public class 문자열을_정수로_바꾸기 {

    public int solution(String s) {
        int answer = 0;

        if (s.charAt(0) == '+') {

            answer = Integer.parseInt(s.substring(1));

        } else if (s.charAt(0) == '-') {

            answer = - Integer.parseInt(s.substring(1));

        } else {

            answer = Integer.parseInt(s);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "1234";
        new 문자열을_정수로_바꾸기().solution(s);

    }
}
