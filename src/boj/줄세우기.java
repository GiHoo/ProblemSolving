package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬 문제
public class 줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[N + 1]; // 다른 노드로부터 들어오는 노드
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());

            graph.get(small).add(big);
            inDegree[big]++;
        }

        List<Integer> solution = solution(N, M, graph, inDegree);

        for (int x : solution) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(int N, int M, List<List<Integer>> graph, int[] inDegree) {
        List<Integer> solution = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 위상 정렬 포인트
        // 진입 차수가 0인 노드 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 큐에서 노드를 꺼내면서 위상 정렬
        while (!queue.isEmpty()) {
            int node = queue.poll();
            solution.add(node);

            for (int next : graph.get(node)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return solution;


    }
}
