package algorithm.programmers.Level1.문자열_내_p와_y의_개수;

class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') pCnt++;
            else if (c == 'y') yCnt++;
        }

        return pCnt == yCnt;
    }
}
