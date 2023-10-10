package algorithm.programmers.Level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String s)
    {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (!stack.empty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() > 0 ? 0 : 1;
    }

    public static void main(String[] args) {

        System.out.println(new 짝지어_제거하기().solution("aabaacb"));
    }
}


