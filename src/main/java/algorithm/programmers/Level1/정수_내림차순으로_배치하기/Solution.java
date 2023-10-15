package algorithm.programmers.Level1.정수_내림차순으로_배치하기;

class Solution {

    public long solution(long n) {

        char[] charArray = String.valueOf(n).toCharArray();

        // 버블정렬
        for (int i = 0; i < charArray.length -1 ; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] < charArray[j]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }

        return Long.parseLong(new String(charArray));
    }
}
