package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 험난한등굣길 {

    static int N, M;
    static int[][] moves = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken()) - 1;
            int D = Integer.parseInt(st.nextToken());

            matrix[R][C] = 1;

            for (int j = 0; j < D; j++) {
                if (checkBoundary(R - D + j, C + j)) matrix[R - D + j][C + j] = 1;
                if (checkBoundary(R + j, C + D - j)) matrix[R + j][C + D - j] = 1;
                if (checkBoundary(R + D - j, C - j)) matrix[R + D - j][C - j] = 1;
                if (checkBoundary(R - j, C - D + j)) matrix[R - j][C - D + j] = 1;
            }
        }

        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == N - 1 && node.y == M - 1) {
                System.out.println("YES");
                System.out.println(node.distance);

                return;
            }

            for (int i = 0; i < moves.length; i++) {
                int nx = node.x + moves[i][0];
                int ny = node.y + moves[i][1];

                if (checkBoundary(nx, ny) && matrix[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, node.distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println("NO");
    }

    private static boolean checkBoundary(int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < M);
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
