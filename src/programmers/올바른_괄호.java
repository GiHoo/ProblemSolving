package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호 {

    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if (deque.isEmpty() || tmp == '(') {
                deque.add(tmp);
            } else {
                if (deque.peek() == '(') {
                    deque.poll();
                } else {
                    return false;
                }
            }
        }

        if (!deque.isEmpty()) return false;

        return true;
    }
}
