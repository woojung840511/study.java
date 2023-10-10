package algorithm.programmers.Level0._03_문자열_반복해서_출력하기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        while (n > 0) {
            System.out.print(str);
            n--;
        }
    }
}
