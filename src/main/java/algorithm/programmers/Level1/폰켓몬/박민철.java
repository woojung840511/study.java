package algorithm.programmers.Level1.폰켓몬;

import java.util.HashSet;

public class 박민철 {


    public static int solution(int[] nums) throws Exception {
        HashSet set = new HashSet();
        int answer = 0;

        if(nums.length % 2 == 0){
            int bring = nums.length / 2;
            for(int i = 0; i<nums.length; i++){
                set.add(nums[i]);      //set에 넣어 중복 제거
            }

            if(bring > set.size()){
                answer = set.size();
            } else if(set.size() > bring){
                answer = bring;
            } else {
                answer = bring;
            }
        }
        else {
            throw new Exception("제한사항 위반");
        }
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) throws Exception {
//        solution(new int[]{3, 1, 2, 3});
        solution(new int[]{3,3,3,2,2,4});
//        solution(new int[]{3,3,3,2,2,2});
    }
}

