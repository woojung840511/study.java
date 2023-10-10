package algorithm.programmers.Level1;

public class 서울에서_김서방_찾기 {

    public String solution(String[] seoul) {
        int count = 0;
        for (String s : seoul) {
            if (s.equals("Kim")) {
                break;
            }
            count++;
        }
        return "김서방은 " + count + "에 있다";
    }

    public static void main(String[] args) {
        System.out.println(new 서울에서_김서방_찾기().solution(new String[]{"Jane", "Kim"}));

    }
}
