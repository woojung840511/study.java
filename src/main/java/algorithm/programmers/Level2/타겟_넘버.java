package algorithm.programmers.Level2;/*
package Level2;

import java.util.ArrayList;
import java.util.List;

public class 타겟_넘버 {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        List<Integer> sumResultList = new ArrayList<>();

        int result = getSumResult(numbers, 0, 0, target, sumResultList);

        return answer;
    }

    public int getSumResult(int[] numbers, int index, int i, int target, List<Integer> sumResultList) {
        int[] elements = {1, -1};
        int result = 0;
        index++;

        if (index < numbers.length - 1 || i < 1) {
            i++;
            i = i % 2;
            result += getSumResult(numbers, index, i, target, sumResultList);

        } else {
            result = numbers[index] * elements[i];
            sumResultList.add()
        }
        return result;
    }

    public static void main(String[] args) {
        new 타겟_넘버().solution(new int[]{1, 2,3,4,5}, 3);
    }


}
*/
