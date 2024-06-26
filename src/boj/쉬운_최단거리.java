package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 링크: https://www.acmicpc.net/problem/14940
 * 메모리: 49828 KB
 * 시간: 668 ms
 * 시간 복잡도: O(N^2)
 * 공간 복잡도: O(N^2)
 */

public class 쉬운_최단거리 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] moves = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;

                if (input == 2) {
                    queue.add(new Node(i, j));
                    map[i][j] = 0;
                    visited[i][j] =true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int distance = map[x][y];

            for (int i = 0; i < moves.length; i++) {
                int nx = x + moves[i][0];
                int ny = y + moves[i][1];

                if (validateNode(nx, ny)) {
                    queue.add(new Node(nx, ny));
                    map[nx][ny] = distance + 1;
                    visited[nx][ny] = true;
                }
            }
        }

        setUnreachable();

        System.out.println(printAnswer());
    }

    private static StringBuilder printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb;
    }

    private static boolean validateNode(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && !visited[nx][ny]);
    }

    private static void setUnreachable() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) map[i][j] = -1;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

