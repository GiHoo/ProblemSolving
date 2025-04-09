package programmers;

import java.util.*;

public class 가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] info : edge) {
            graph.get(info[0]).add(info[1]);
            graph.get(info[1]).add(info[0]);
        }


        visited[1] = true;
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            distances[curr.number] = curr.distance;

            for (int next : graph.get(curr.number)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, curr.distance + 1));
                }
            }
        }

        int answer = 0;
        int maxDistance = 0;
        for (int distance : distances) {
            if (distance > maxDistance) {
                maxDistance = distance;
                answer = 1;
            } else if (distance == maxDistance) {
                answer++;
            }
        }

        return answer;
    }

    static class Node {
        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }
}


/*
가장 먼 노드
14:25 ~ 14:55

1번 노드에서 가장 멀리 떨어진 노드


 */


