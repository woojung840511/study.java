package codingTest.inflearn.javaAlgorithm._02_대소문자_변환;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2. 대소문자 변환
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 */
public class Main {

    public String solution(String str) {
        String answer = "";
        for (char c : str.toCharArray()) {
            answer += (Character.isLowerCase(c) ?
                    Character.toUpperCase(c)
                    : Character.toLowerCase(c));
        }
        return answer;
    }
    public static void main (String[] args)  {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new Main().solution(str));
    }
}
