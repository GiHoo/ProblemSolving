package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 몸풀기_문제_그래프 {

    static ArrayList<Integer>[] adjList;

    static List<Integer> answer_dfs = new ArrayList<>();
    static boolean[] visited_dfs;
    static List<Integer> answer_bfs = new ArrayList<>();
    static boolean[] visited_bfs;

    public static void solution(int[][] graph, int start, int n) {
        visited_dfs = new boolean[n + 1];
        visited_bfs = new boolean[n + 1];
        adjList = new ArrayList[n + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] node : graph) {
            adjList[node[0]].add(node[1]);
        }

        dfs(start);
        bfs(start);

        int[] dfs_array = answer_dfs.stream().mapToInt(Integer::intValue).toArray();
        int[] bfs_array = answer_bfs.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < dfs_array.length; i++) {
            System.out.print(dfs_array[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < bfs_array.length; i++) {
            System.out.print(bfs_array[i] + " ");
        }
    }

    private static void dfs(int start) {
        answer_dfs.add(start);
        visited_dfs[start] = true;

        for (int i = 0; i < adjList[start].size(); i++) {
            int next = adjList[start].get(i);
            if (!visited_dfs[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        answer_bfs.add(start);
        visited_bfs[start] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (int i = 0; i < adjList[tmp].size(); i++) {
                int next = adjList[tmp].get(i);

                if (!visited_bfs[next]) {
                    queue.add(next);
                    answer_bfs.add(next);
                    visited_bfs[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int start = 1;
        int n = 5;
        solution(graph, start, n);
    }
}
