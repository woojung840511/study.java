package algorithm.programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class 문자열_압축 {
    public int solution(String s) {

        Set<Integer> lengthSet = new HashSet<>();
        int beginIndex;
        int len = s.length();

        for (int i = 1; i <= len; i++) {

            StringBuilder sb = new StringBuilder();
            String prevSubstring = "";
            String currentSubstring = "";
            String repeatedTime = "";
            int repeat = 1;
            beginIndex = 0;

            while (beginIndex < len) {

                int endIndex = Math.min(beginIndex + i, len);
                currentSubstring = s.substring(beginIndex, endIndex);

                boolean prevRepeated = prevSubstring.equals(currentSubstring);
                if (prevRepeated) {
                    repeat ++;

                    if (endIndex == len) {
                        sb.append(repeat).append(currentSubstring);
                    }

                } else {
                    repeatedTime = repeat == 1 ? "" : String.valueOf(repeat);
                    sb.append(repeatedTime).append(prevSubstring);

                    if (endIndex == len) {
                        sb.append(currentSubstring);
                    }

                    repeat = 1;
                }

                prevSubstring = currentSubstring;
                beginIndex += i;
            }

            String resultStr = sb.toString();
            lengthSet.add(resultStr.length());
        }

        return lengthSet.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
    }

    public static void main(String[] args) {
        System.out.println(new 문자열_압축().solution("aabbaccc"));;
        System.out.println(new 문자열_압축().solution("ababcdcdababcdcd"));;
        System.out.println(new 문자열_압축().solution("abcabcdede"));;
        System.out.println(new 문자열_압축().solution("abcabcabcabcdededededede"));;
        System.out.println(new 문자열_압축().solution("xababcdcdababcdcd"));;
    }
}
