package algorithm.programmers.Level2;

public class 멀쩡한_사각형_미완료 {
    public long solution(int w, int h) {

        double slope = -1.0 * h / w;

        long count = 0;

        if (w == h) {
            count = w;
        } else {

        }
        boolean cut = false;
        for (int y = h - 1; y >= 0; y--) {
            for (int x = 1; x <= w; x++) {

                double yValue = slope * x  + h ;
                double xValue = (y - h) / slope ;

                if (xValue < x || yValue > y) {
                    count = count + 2;
                } else {
                    count++;
                }
            }
        }



        long answer = (long) w * h - count;
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        new 멀쩡한_사각형_미완료().solution(8, 12);
    }
}
