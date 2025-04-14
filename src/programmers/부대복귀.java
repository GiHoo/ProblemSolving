package programmers;

import java.util.*;

public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // roads로 그래프를 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int s = roads[i][0];
            int e = roads[i][1];

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);

        // destination에서 시작하여 역방향 BFS 진행
        Queue<int[]> queue = new LinkedList<>();
        distances[destination] = 0;
        queue.add(new int[]{destination, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int next : graph.get(curr[0])) {
                if (distances[next] == -1) {
                    distances[next] = curr[1] + 1;
                    queue.add(new int[]{next, curr[1] + 1});
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < sources.length; i++) {
            answer.add(distances[sources[i]]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        부대복귀 test = new 부대복귀();
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;

        int[] result = test.solution(n, roads, sources, destination);
        System.out.println(Arrays.toString(result)); // [2, -1, 0]
    }
}

/*

부대복귀
18:45 ~ 50 / 58 ~ 13 / 17 ~

- 지도에 위치는 유일한 번호로 구분
- 두 지역 간 길 통과에 걸리는 시간은 1

지도 정보를 통해 최단시간 복귀

총 지역 수 n
두 지역 왕복 길 roads
각 부대원이 위치한 서로 다른 지역 sources
지역 destination


sources에서 destination으로 갈 수 있는 최단 거리를 구해야 함
그래프 만들고 bfs?

역시 시간 복잡도 문제 발생
탐색을 진행하면서 dp 형식으로 저장하자

 */
