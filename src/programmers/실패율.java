package programmers;

import java.util.HashMap;
import java.util.Map;

public class 실패율 {

    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> failures = new HashMap<>();

        int[] current = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            current[stages[i]]++;
        }

        double totalChallenger = stages.length;

        for (int i = 1; i <= N; i++) {
            int currentPosition = current[i];

            if (currentPosition == 0) {
                failures.put(i, 0.);
            } else {
                failures.put(i, currentPosition / totalChallenger);
                totalChallenger -= currentPosition;
            }
        }

        return failures.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}
