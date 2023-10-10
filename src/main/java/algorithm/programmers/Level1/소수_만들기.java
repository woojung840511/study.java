package algorithm.programmers.Level1;

import java.util.ArrayList;
import java.util.List;

public class 소수_만들기 {

    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> sumResults = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) { // 3
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sumResults.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }


        for (Integer sumResult : sumResults) {

            boolean sosu = true;
            for (int i = 2; i < sumResult; i++) {
                if (sumResult % i == 0) {
                    sosu = false;
                    break;
                }
            }

            if (sosu) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(new 소수_만들기().solution(new int[]{1,2,7,6,4}));
        //[1,2,3,4] 1
        //[1,2,7,6,4] 4
    }
}
