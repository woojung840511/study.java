package algorithm.programmers.Level1;

import java.util.HashMap;
import java.util.Map;

public class 요일_2016년 {
    public String solution(int a, int b) {
        String answer = "";

        int plusDay = 0;
        for (int i = 2; i <= a; i++) {
            int lastMonthDays = 0;
            switch (i - 1) {
                case 2:
                    lastMonthDays = 29;
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    lastMonthDays = 31;
                    break;
                default:
                    lastMonthDays = 30;
            }

            System.out.println("i - 1 = " + (i - 1));
            System.out.println("lastMonthDays = " + lastMonthDays);
            plusDay += lastMonthDays;
            System.out.println("plusDay = " + plusDay);
        }

        plusDay += b;

        Map<Integer, String> dayMap = new HashMap<>();
        dayMap.put(0, "THU");
        dayMap.put(1, "FRI");
        dayMap.put(2, "SAT");
        dayMap.put(3, "SUN");
        dayMap.put(4, "MON");
        dayMap.put(5, "TUE");
        dayMap.put(6, "WED");

        answer = dayMap.get(plusDay % 7);


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 요일_2016년().solution(5, 26));
    }
}
