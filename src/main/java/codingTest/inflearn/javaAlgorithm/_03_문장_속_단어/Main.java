package codingTest.inflearn.javaAlgorithm._03_문장_속_단어;

import java.util.Scanner;

/**
 * 3. 문장 속 단어
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 * ex
 *  input : it is time to study
 *  output : study
 */
public class Main {

    public String solution(String str) {
        String answer = "";
        int begin = 0;
        int max = str.length();

        while(begin < max) {
            int end = str.indexOf(" ", begin);
            String part = end == -1 ? str.substring(begin) : str.substring(begin, end);

            if (answer.length() < part.length()) answer = part;

            boolean hasSpace = end != -1;
            begin += (part.length() + (hasSpace ? 1 : 0));
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new Main().solution(str));
    }
}
