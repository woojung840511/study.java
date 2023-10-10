package algorithm.leetCode;

public class _14 {
    public String longestCommonPrefix(String[] strs) {

        int j = 0;
        char prv = 0;
        String prifix = "";

        for (int i = 0; i < strs.length; i++) {
            if (j < strs[i].length()) {

                char c = strs[i].charAt(j);

                if (i == 0) {
                    prv = c;
                } else if (prv != c){
                    break;
                }

                if (i + 1 == strs[i].length()) {
                    prifix += prv;
                }

            } else break;
        }

        
        return "";
    }
}
