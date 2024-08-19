package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 병약한윤호 {

    static char[] BLD = {'B', 'L', 'D'};

    static Queue<Pill> queue = new LinkedList<>();
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int answer = 0;

        queue.add(new Pill(input, 0, 2));
        map.put(input, map.getOrDefault(input, 0) + 1);
        while (!queue.isEmpty()) {
            Pill pill = queue.poll();

            answer = Math.max(answer, pill.eatPillCounts);

            String remainingPills = pill.remainingPills;
            int nextEatingPillNumber = (pill.previousEatingPillNumber + 1) % 3;
            char nextEatingPill = BLD[nextEatingPillNumber];

            if (!remainingPills.isEmpty()) {
                if (remainingPills.charAt(0) == nextEatingPill) {
                    String tmp = remainingPills.substring(1);

                    validateDuplication(tmp, pill, nextEatingPillNumber);
                }

                if (remainingPills.charAt(remainingPills.length() - 1) == nextEatingPill) {
                    String tmp = remainingPills.substring(0, remainingPills.length() - 1);

                    validateDuplication(tmp, pill, nextEatingPillNumber);
                }
            }
        }

        System.out.print(answer);
    }

    private static void validateDuplication(String tmp, Pill pill, int nextEatingPillNumber) {
        if (!map.containsKey(tmp)) {
            queue.add(new Pill(tmp, pill.eatPillCounts + 1, nextEatingPillNumber));
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
    }

    private static class Pill {
        String remainingPills;
        int eatPillCounts;
        int previousEatingPillNumber;

        public Pill(String remainingPills, int eatPillCounts, int previousEatingPillNumber) {
            this.remainingPills = remainingPills;
            this.eatPillCounts = eatPillCounts;
            this.previousEatingPillNumber = previousEatingPillNumber;
        }
    }
}
