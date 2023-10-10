package algorithm.programmers.Level1.모의고사;

import java.util.ArrayList;

public class 박민철 {

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] person1 = {1,2,3,4,5};
        int point1 = 0;

        int[] person2 = {2,1,2,3,2,4,2,5};
        int point2 = 0;

        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int point3 = 0;

        for(int i =0; i<answers.length; i++) {
            if (person1[i % person1.length] == answers[i]) point1++;
            if (person2[i % person2.length] == answers[i]) point2++;
            if (person3[i % person3.length] == answers[i]) point3++;
        }

        int max = Math.max(Math.max(point1, point2), point3);
        ArrayList<Integer> list = new ArrayList();
        if(max == point1) list.add(1);
        if(max == point2) list.add(2);
        if(max == point3) list.add(3);

        answer = new int[list.size()];

        for(int i = 0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String[] args) throws Exception {
//        solution(new int[]{1,2,3,4,5});
        solution(new int[]{1,2,3,4,5,4});
//        solution(new int[]{1,3,2,4,2});

    }
}

