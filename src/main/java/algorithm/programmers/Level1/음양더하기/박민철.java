package algorithm.programmers.Level1.음양더하기;

public class 박민철 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i<absolutes.length; i++){

            if (signs[i] == true) {
                answer += absolutes[i];
            } else {
                answer += (absolutes[i] * -1);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{4, 7, 12}, new boolean[]{true, false, true});
    }
}
