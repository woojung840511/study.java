package algorithm.programmers.Level1.모의고사;

import java.util.ArrayList;
import java.util.List;

public class 김용준 {

    public static void main(String[] args) {

        int[] answers = {1,3,2,4,2};

        solution(answers);
    }

    public static int[] solution(int answers[]) {
        /*
        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        [1,2,3,4,5]	[1]
        [1,3,2,4,2]	[1,2,3]

        시험은 최대 10,000 문제로 구성되어있습니다.
        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
         */

        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int supojaSum1 = mh(supoja1, answers);
        int supojaSum2 = mh(supoja2, answers);
        int supojaSum3 = mh(supoja3, answers);

        List<Integer> saveList = new ArrayList<>();
        System.out.println(supojaSum1);
        System.out.println(supojaSum2);
        System.out.println(supojaSum3);

        int[] supoja = {supojaSum1, supojaSum2, supojaSum3};

        int max = supoja[0];
        for(int i=0;i<supoja.length;i++) {
            if (max < supoja[i]) {
                max = supoja[i];
            }
        }

        for(int i=0; i<supoja.length; i++){

            if(supoja[i] == max){
                saveList.add(i+1);
                System.out.println("saveList 값 : "+saveList);
            }
        }

        int[] answer = new int[saveList.size()];

        System.out.println("answer의 크기 : "+answer.length);
        for(int i=0; i<saveList.size(); i++){
            answer[i] = saveList.get(i);
            System.out.println("answer의 값 : "+answer[i]);
        }



        return answer;
    }


    static int mh(int[] supoja, int[] answers){

        int supojaSum = 0;
        int supojaSize = 0;

        for(int i=0; i<answers.length; i++){

            if(supoja.length > supojaSize) {
            }else{
                supojaSize = 0;
            }

            if (supoja[supojaSize] == answers[i]) {
                supojaSum++;
            }
            supojaSize++;

        }
        return supojaSum;
    }

}
