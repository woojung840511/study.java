package algorithm.programmers.Level1.부족한금액계산하기;

public class 박민철 {

    public static long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;

        for(int i = 1; i<=count; i++){              // (price * 1) + (price * 2) + (price * 3) + ... + (price * count)
            sum += price * i;
        }

        answer = sum < money ? 0 : (sum - money);

        return answer;
    }

    public static void main(String[] args) throws Exception {
        solution(3, 20, 4);
    }
}

