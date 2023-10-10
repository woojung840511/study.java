package algorithm.programmers.Level1.실패율;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 조하연 {


    class Solution {
        public int[] solution(int N, int[] stages) {
            //key : 스테이지번호, value : Level1.실패율
            HashMap<Integer, Double> failMap = new HashMap<>();
            List<Integer> stageList = Arrays.stream(stages).boxed().collect(Collectors.toList());
            //i번째 스테이지 Level1.실패율 구하기
            for (int i = 1; i <= N; i++) {
                int userCnt = stageList.size();     //스테이지에 도달한 유저 수
                int stayUserCnt = Collections.frequency(stageList, i); //i번째 스테이지에 머무르고 있는 유저 수
                if(userCnt != 0) {
                    double failRate = (double) stayUserCnt / userCnt;
                    failMap.put(i, failRate);
                    stageList.removeAll(Arrays.asList(i));
                } else {
                    failMap.put(i, 0.0);
                }
            }
            //실패율이 높은순으로 스테이지 순번 정렬
            ArrayList<Integer> keyList = new ArrayList<>(failMap.keySet());
            Collections.sort(keyList, (k1, k2) -> (failMap.get(k2).compareTo(failMap.get(k1))));
            //list를 int[]로 변환
            int[] result = new int[keyList.size()];
            for(int i=0; i<keyList.size(); i++) {
                result[i] = keyList.get(i);
            }
            return result;
        }
    }
}
