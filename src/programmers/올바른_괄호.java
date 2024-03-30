package programmers;

import java.util.Stack;

public class 올바른_괄호 {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    boolean solution(String s) {
        boolean answer = true;

        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chs.length; i++) {
            if (stack.isEmpty()) {
                if (chs[i] == OPEN) {
                    stack.push(chs[i]);
                } else {
                    answer = false;
                    break;
                }
            } else {
                if (chs[i] == OPEN) {
                    stack.push(chs[i]);
                } else {
                    if (stack.peek() == OPEN) {
                        stack.pop();
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
