package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 기능_개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Deque<Integer> d_progresses = new ArrayDeque<>();
        Deque<Integer> d_speeds = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            d_progresses.addLast(progresses[i]);
            d_speeds.addLast(speeds[i]);
        }

        while (!d_progresses.isEmpty()) {
            int cnt = 0;

            for (int i = 0; i < d_progresses.size(); i++) {
                int progress = d_progresses.pollFirst();
                int speed = d_speeds.pollFirst();
                progress += speed;
                d_progresses.addLast(progress);
                d_speeds.addLast(speed);
            }

            // 100 이상이면 출하
            while (!d_progresses.isEmpty() && d_progresses.peekFirst() >= 100) {
                cnt++;
                d_progresses.pollFirst();
                d_speeds.pollFirst();
            }

            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        기능_개발 s = new 기능_개발();
        s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }
}
