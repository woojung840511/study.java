package algorithm.programmers.Level1;

public class 평균_구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        for (int i : arr) {
            answer += i;
        }
        return answer/arr.length;
//        return Arrays.stream(arr).summaryStatistics().getAverage();
    }
}
