package algorithm.programmers.Level1.서울에서_김서방_찾기;

import java.util.Arrays;

public class Solution {
    public String solution(String[] seoul) {

/*        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 "+ x + "에 있다";*/

        int idx = 0;
        for (String s : seoul) {
            if (s.equals("Kim")) {
                break;
            }
            idx++;
        }
        return "김서방은 " + idx + "에 있다";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"Jane", "Kim"}));
    }
}
