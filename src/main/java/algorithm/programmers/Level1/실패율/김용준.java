package algorithm.programmers.Level1.실패율;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 김용준 {

        public static void main(String[] args) {

            int N = 5;
            int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

            solution(N, stages);
        }



        //Level1.실패율
        public static int[] solution(int N, int[] stages) {

        /*
        스테이지에 도달했으나, 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
        전체 스테이지수(사용자 수) : N
        게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어짐
        ★★★★ : 실패율이 높은 스테이지부터 *내림차순
        */

            int[] answer = new int[N];
            Map<Integer,Double> listMan = new HashMap<>();

            for(int i=1; i<=N; i++) {
                int runMan = 0;
                int stopMan = 0;

                for(int j=0; j < stages.length; j++) {

                    //기본 적으로 클러어 중인 사람과 클리어를 한 사람을 나누는 게 포인트 였음!!
                    if(i == stages[j]) {
                        runMan++;
                    }

                    if(i<=stages[j]) {
                        stopMan++;
                    }
                }

                double score = 0;
                if(runMan!=0 && stopMan!=0) {
                    score = (double)runMan / (double)stopMan * 100.0;
                }


                System.out.println(runMan+"/"+stopMan+" / 평균 클리어 : "+score+" / 스테이지 : "+i);
                listMan.put(i, score);

            }

            for(int i=0; i<N; i++) {
                double lastScore = -1;
                int lastScoreKey = 0;
                for(Integer key : listMan.keySet()) {
                    if(lastScore < listMan.get(key)) {
                        lastScore = listMan.get(key);
                        lastScoreKey = key;
                    }
                }
                answer[i] = lastScoreKey;
                listMan.remove(lastScoreKey);
            }

            System.out.println(Arrays.toString(answer));


            return answer;
        }
        //3,4,2,1,5 -- 답
    }

