package algorithm.leetCode;

import java.util.HashSet;
import java.util.Set;

public class _3_Longest_Substring {

    public static void main(String[] args) {
//        new _3_Longest_Substring().lengthOfLongestSubstring("abcabcbb");
        int result = new _3_Longest_Substring().lengthOfLongestSubstring("aab");
//        int result = new _3_Longest_Substring().lengthOfLongestSubstring("abcabcbb");
        System.out.println("result = " + result);
    }

    public int lengthOfLongestSubstring(String s) {

        Set<String> patterns = new HashSet<>();
        String pattern = "";

        for (int i = 0; i < s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));

            if (pattern.contains(currentChar)) {
                patterns.add(pattern);
                int idx = pattern.indexOf(currentChar);
                pattern = pattern.substring(idx + 1) + currentChar;
            } else {
                pattern += currentChar;
            }
        }
        patterns.add(pattern);

        int max = 0;
        for (String p : patterns) {
            max = Math.max(max, p.length());
        }
        return max;
    }
}
