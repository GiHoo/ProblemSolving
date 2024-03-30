package programmers;

import java.util.HashMap;
import java.util.Map;

public class 실패율 {

    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> failures = new HashMap<>();

        int length = stages.length;

        for (int i = 0; i < length; i++) {
            double failure;

            if (i == 0) {
                failure = (double) stages[i] / length;
            } else {
                failure = (double) stages[i] / (length - stages[i - 1]);
            }

            failures.put(i, failure);
        }

        return failures.entrySet().stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}
