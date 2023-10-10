package algorithm.programmers.Level1.폰켓몬;
import java.util.ArrayList;
public class 김용준 {

    public int solution(int[] nums) {
        int answer = 0;
        int size = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer item : nums){
            if(!arrayList.contains(item))
                arrayList.add(item);
        }
        System.out.println("값 : "+arrayList.size());
        if(arrayList.size() <= nums.length/2){
            answer = arrayList.size();
        }else{
            answer = nums.length/2;
        }
        return answer;
    }
}
