package algorithm.programmers.Level1.콜라츠_추측;

public class Solution {
    /*
    1-1. 입력된 수가 짝수라면 2로 나눕니다.
    1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
    2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
     */
    public int solution(int num) {
        int answer = 0;
        long longNum = num;
        while (longNum != 1 && answer <= 500) {
            if (longNum % 2 == 0) {
                longNum /= 2;
            } else {
                longNum = (longNum * 3) + 1;
            }
            answer++;
        }

        return answer > 500 ? -1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(626331));
    }
}


/* 아주 깔끔해보였다.
class Collatz {
    public int collatz(int num) {
    long n = (long)num;
    for(int i=0; i<500; i++){
        if(n==1) return i;
      n = (n%2==0) ? n/2 : n*3+1;
    }

        return -1;
    }
}

*/