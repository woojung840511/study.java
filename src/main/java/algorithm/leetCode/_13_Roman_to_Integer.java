package algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

public class _13_Roman_to_Integer {

    public int romanToInt(String s) {

        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        for (int idx = 0; idx < s.length(); idx++) {

            int curr = roman.get(s.charAt(idx));

            if (idx + 1 < s.length()) {

                int next = roman.get(s.charAt(idx + 1));
                if ((curr == 1 && (next == 5 || next == 10))
                        || (curr == 10 && (next == 50 || next == 100))
                        || (curr == 100 && (next == 500 || next == 1000))) {

                    result += (next - curr);
                    idx += 1;
                } else {
                    result += curr;
                }
                // 있다면 다음에 오는 c가 빼기에 해당되는 단어인지
                // 뺀다
                // 인덱스에 2를 더한다.

            } else {
                result += curr;
            }


        }

        return result;

    }

    public static void main(String[] args) {

        String input = "MCMXCIV";
        int i = new _13_Roman_to_Integer().romanToInt(input);
        System.out.println("i = " + i);
    }

            /*
        Input: s = "III"
        Output: 3
        Explanation: III = 3.

        Input: s = "LVIII"
        Output: 58
        Explanation: L = 50, V= 5, III = 3.

        Input: s = "MCMXCIV"
        Output: 1994
        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
         */
}
