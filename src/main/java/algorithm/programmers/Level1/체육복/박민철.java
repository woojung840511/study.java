package algorithm.programmers.Level1.체육복;

import java.util.ArrayList;
import java.util.List;

public class 박민철 {

    public static int solution(int n, int[] lost, int[] reserve) {
        //최소한의 체육복을 가지고 있는 사람 n - lost
        int answer = n - lost.length;       // 5-2 = 3
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0; i<lost.length; i++){         // list = {2,4}
            list.add(lost[i]);
        }
        for(int i = 0; i<reserve.length; i++){     // list2 = {3}
            list2.add(reserve[i]);
        }
        for(int i = list.size()-1; i >= 0; i--){
            for(int j = list2.size()-1; j >= 0; j--){
                if(list.get(i) == list2.get(j)){
                    list.set(i, -1);
                    list2.set(j, -1);
                }
            }
        }
        for(int i = 0; i < list.size(); i++){   //
            for(int j = 0; j < list2.size(); j++){        //2
                if(list2.get(j) == list.get(i)-1 || list2.get(j) == list.get(i)+1){
                    answer++;
                    list2.set(j , -1);
                    break;
                }
            }
        }
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == -1){
                answer++;
            }
        }
        //reserver 여분가진 얘 번호
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        solution(5, new int[]{2,4},new int[]{3});       //4
//        solution(5, new int[]{2,4},new int[]{1,3,5});   //5
//        solution(5, new int[]{1,2,3},new int[]{2,3,4});   //4
//        solution(3, new int[]{3},new int[]{1}); //2
    }
}
