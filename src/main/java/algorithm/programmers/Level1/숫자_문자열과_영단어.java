package algorithm.programmers.Level1;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class 숫자_문자열과_영단어 {

    public int solution(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        while(!Pattern.matches("(^[0-9]*$)", s)) { // 문자가 포함되어 있다면
            // s에 map key가 있으면 value를 꺼내서, value로 교체한다.
            for (String key : map.keySet()) {
                if (s.contains(key)) {
                    s = s.replaceAll(key, String.valueOf(map.get(key)));
                    System.out.println("key = " + key);
                    System.out.println("s = " + s);
                }
            }
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        new 숫자_문자열과_영단어().solution(s);
    }

}
