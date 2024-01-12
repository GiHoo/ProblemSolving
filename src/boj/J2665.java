package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class J2665 {

    static int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    static int N;
    static int[][] miro;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        miro = new int[N][N];
        answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                miro[i][j] = input.charAt(j) - '0';
                answer[i][j] = Integer.MAX_VALUE;
            }
        }

        solution();

        System.out.println(answer[N - 1][N - 1]);
    }

    private static void solution() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0));
        answer[0][0] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < move.length; i++) {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if (isAvailable(nx, ny) && answer[nx][ny] > answer[x][y]) {
                    if (miro[nx][ny] == 1) {
                        answer[nx][ny] = answer[x][y];
                    } else {
                        answer[nx][ny] = answer[x][y] + 1;
                    }
                    queue.add(new Node(nx, ny));
                }
            }
        }


    }

    private static boolean isAvailable(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
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
