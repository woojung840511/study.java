package algorithm.programmers.Level1.실패율;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 박민철 {
    public static int[] solution(int N, int[] stages) {
        int[] answer;
        List<Integer> intList =  new ArrayList<>();
        for(int i = 0; i< stages.length; i++){
            intList.add(stages[i]);
        }

        HashMap<Integer, Double> setting = new HashMap<>();

        int 스테이지_수 = N;
        double count = 0;
        double falseSize;

        for(int i = 1; i<=N; i++){
            for(int j = 0; j<intList.size(); j++){
                if(intList.get(j).equals(i)){
                    count++;
                }
            }
            if(intList.size() == 0){            //N = 5, {2,1,2,1,4}일 경우 5스테이지의 실패율까지 구해야하므로 0/0 처리
                falseSize = 0;
            } else {
                falseSize = count / (double) intList.size();
            }
            setting.put(i, falseSize);

            for(int z = intList.size()-1; z >= 0; z--){
                if(intList.get(z) == i){
                    intList.remove(z);
                }
            }
            count = 0;
        }

        ArrayList<Integer> list = new ArrayList<>(setting.keySet());
        Collections.sort(list, (k1, k2) -> ( setting.get(k2).compareTo(setting.get(k1)) ));
        answer = new int[list.size()];

        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        for(int el : answer){
            System.out.println(el);
        }

        return answer;
    }

    public static void main(String[] agrs){
//        solution(5, new int[]{2,1,2,6,2,4,3,3});        //return 3,4,2,1,5
        solution(4, new int[]{4,4,4,4,4});              // return 4,1,2,3
    }
}
