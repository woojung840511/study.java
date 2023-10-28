package algorithm.programmers.Level1.핸드폰_번호_가리기;

public class Solution {

    public String solution(String phone_number) {

        int asteriskCount = phone_number.length() - 4;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phone_number.length(); i++) {
            if (i < asteriskCount) {
                sb.append('*');
            } else {
                sb.append(phone_number.charAt(i));
            }
        }

        return sb.toString();
    }

/*    public String solution(String phone_number) { // 깔끔했던 다른 사람의 풀이
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }*/

    public static void main(String[] args) {
        System.out.println(new Solution().solution("01033334444"));
    }
}
