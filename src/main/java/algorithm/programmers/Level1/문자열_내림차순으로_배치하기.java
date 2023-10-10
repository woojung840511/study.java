package algorithm.programmers.Level1;

public class 문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length-i-1; j++) {

                int compare = Character.compare(chars[j], chars[j+1]);
                if (compare < 0) {
                    char temp = chars[j+1];
                    chars[j+1] = chars[j];
                    chars[j] = temp;
                };
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        new 문자열_내림차순으로_배치하기().solution("Zbcdefg");
    }
}
