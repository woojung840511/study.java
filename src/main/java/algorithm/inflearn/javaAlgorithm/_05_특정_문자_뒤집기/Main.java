package algorithm.inflearn.javaAlgorithm._05_특정_문자_뒤집기;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        char[] charArray = str.toCharArray();
        int lt = 0, rt = charArray.length - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(charArray);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(new Main().solution(str));

    }
}
