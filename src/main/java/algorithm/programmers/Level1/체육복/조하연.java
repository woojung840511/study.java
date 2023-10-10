package algorithm.programmers.Level1.체육복;

public class 조하연 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        //여벌이 있는 학생이 도난당한 케이스를 처리.
        //자신의 것으로 대체하고, 아무도 빌려줄 수 없는 상태가 됨.
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(reserve[j] == lost[i]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(reserve[j] == lost[i]-1) {
                    //잃어버린 애의 왼쪽 애가 체육복을 제공하는 케이스
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                } else if(reserve[j] == lost[i]+1) {
                    //잃어버린 애의 오른쪽 애가 체육복을 제공하는 케이스
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        //lost 배열에서 값이 -1인 애들은 체육복을 빌린 상태.
        for(int i=0; i<lost.length; i++) {
            if(lost[i] != -1) {
                answer--;
            }
        }
        return answer;
    }

}
