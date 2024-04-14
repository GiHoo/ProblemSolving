package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달 {

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 초기화
        ArrayList<Town>[] list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // 삽입
        for (int[] edge : road) {
            list[edge[0]].add(new Town(edge[1], edge[2]));
            list[edge[1]].add(new Town(edge[0], edge[2]));
        }

        int[] distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE); //

        PriorityQueue<Town> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1.weight, o2.weight));

        pq.add(new Town(1, 0));
        distance[1] = 0;

        while (!pq.isEmpty()) {
            Town current = pq.poll();

            if (distance[current.next] < current.next) {
                continue;
            }

            for (Town town : list[current.next]) {
                if (distance[town.next] > current.weight + town.weight) {
                    distance[town.next] = current.weight + town.weight;
                    pq.add(new Town(town.next, distance[town.next]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }

    static class Town {

        int next;
        int weight;

        public Town(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
}
