package codingTest.inflearn.javaAlgorithm._04_단어_뒤집기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 4. 단어 뒤집기
 */

public class Main {

    // 첫번째 풀이 (StringBuilder 이용하기)
/*    public List<String> solution(String[] inputs) {
        List<String> answerList = new ArrayList<>();

        for (String str : inputs) {
            answerList.add(new StringBuilder(str).reverse().toString());
        }

        return answerList;
    }*/

    // 두번째 풀이 (직접 뒤집기)
    public List<String> solution(String[] inputs) {
        List<String> answerList = new ArrayList<>();

        for (String str : inputs) {
            char[] charArray = str.toCharArray();

            // 내 풀이
/*            for (int i = 0 ; i < (charArray.length / 2) ; i++) {
                int idxFromFront = i;
                int idxFromBack = str.length() - 1 - i;
                char temp = charArray[idxFromFront];
                charArray[idxFromFront] = charArray[idxFromBack] ;
                charArray[idxFromBack] = temp;
            }*/

            // 강사님 풀이: 조금 더 코드 가독성이 좋은 것 같다.
            int lt = 0, rt = str.length() - 1;
            while (lt < rt) {
                char temp = charArray[rt];
                charArray[rt] = charArray[lt];
                charArray[lt] = temp;
                lt++;
                rt--;
            }

            answerList.add(String.valueOf(charArray));
        }

        return answerList;
    }


    public static void main(String[] args) {
        Scanner keybord = new Scanner(System.in);
        int count = keybord.nextInt();
        String[] inputs = new String[count];

        for (int i = 0; i < count; i++) {
            inputs[i] = keybord.next();
        }

        List<String> answerList = new Main().solution(inputs);
        for (String str : answerList) {
            System.out.println(str);
        }
    }
}
