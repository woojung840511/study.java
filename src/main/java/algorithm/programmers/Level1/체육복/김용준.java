package algorithm.programmers.Level1.체육복;
import java.util.ArrayList;
import java.util.List;

public class 김용준 {
    
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        for(int i=0; i<lost.length; i++){
            lostList.add(lost[i]);
        }
        for(int i=0; i<reserve.length; i++){
            reserveList.add(reserve[i]);
        }
        System.out.println("lostList " + lostList);
        System.out.println("reserveList " + reserveList);
        int answer = n-lostList.size();
        System.out.println("도난당한 학생을 뺀 학생 수 : "+answer);
        for(int i=0; i<reserveList.size(); i++) {
            if(reserveList.size() != 0) {
                if (lostList.contains(reserveList.get(i))) {
                    answer++;
                    lostList.remove(reserveList.get(i));
                    reserveList.remove(reserveList.get(i));
                    i--;
                }
            }
        }
        System.out.println("여벌을 도난당한 학생을 뺀 학생 수 : "+answer);
        if(n >= 2 || n <= 30){
            for(int i=0; i<reserveList.size(); i++){
                for(int j=0; j< lostList.size(); j++){
                    if(reserveList.get(i) == lostList.get(j)+1 || reserveList.get(i) == lostList.get(j)-1){
                        lostList.remove(lostList.get(j));
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println("총 수업에 참가하는 학생 수 : "+answer);
        return answer;
    }
}
