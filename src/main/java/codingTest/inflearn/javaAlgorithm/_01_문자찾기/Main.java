package codingTest.inflearn.javaAlgorithm._01_문자찾기;

import java.util.Scanner;

/**
 * 1. 문자 찾기
 */
public class Main {
    public int solution(String str, char c) {
        int answer = 0;
        for (char strItem : str.toLowerCase().toCharArray()) {
            if (strItem == Character.toLowerCase(c)) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String str = keyboard.next();
        char c = keyboard.next().charAt(0);
        System.out.println(new Main().solution(str, c));
        return ;
    }
}
