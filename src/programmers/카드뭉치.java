package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "YES";

        Deque<String> dCards1 = new ArrayDeque<>();
        Deque<String> dCards2 = new ArrayDeque<>();
        Deque<String> dGoal = new ArrayDeque<>();

        for (int i = 0; i < cards1.length; i++) {
            dCards1.addLast(cards1[i]);
        }

        for (int i = 0; i < cards2.length; i++) {
            dCards2.addLast(cards2[i]);
        }

        for (int i = 0; i < goal.length; i++) {
            dGoal.addLast(goal[i]);
        }

        while (!dGoal.isEmpty()) {
            if (!dCards1.isEmpty() && dCards1.peekFirst().equals(dGoal.peekFirst())) {
                dCards1.pollFirst();
                dGoal.pollFirst();
                continue;
            }

            if (!dCards2.isEmpty() && dCards2.peekFirst().equals(dGoal.peekFirst())) {
                dCards2.pollFirst();
                dGoal.pollFirst();
                continue;
            }

            answer = "NO";
            break;
        }

        return answer;
    }
}
