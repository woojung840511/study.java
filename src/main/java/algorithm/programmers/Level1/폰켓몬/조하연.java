package algorithm.programmers.Level1.폰켓몬;


import java.util.HashSet;

public class 조하연 {

    public int solution(int[] nums) {
        int toPickCnt = nums.length / 2;
        HashSet<Integer> ponketmons = new HashSet<>();
        for(Integer num : nums) {
            ponketmons.add(num);
        }
        int kindCnt = ponketmons.size();
        int max = (kindCnt > toPickCnt) ? toPickCnt : kindCnt;
        return max;
    }
    //[3,1,2,3] => 2마리선택 [3,1,2] 3종류 : 2
    //[3,3,3,2,2,4] => 3마리선택 [3,2,4] " 3
    //[3,3,3,2,2,2] => 3마리선택 [3,2] : 2

}
