package algorithm.programmers.Level1.약수의_개수와_덧셈;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            // i의 약수의 개수 구하기

            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    list.add(j);
                }
            }

            answer = list.size() % 2 == 0 ?
                    answer + i :
                    answer - i ;

        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println();
        int answer = new Solution().solution(13, 17);
        System.out.println("answer = " + answer);
    }
}
