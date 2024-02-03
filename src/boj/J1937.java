package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1937 {

    static int N;
    static int[][] forest;
    static int[][] dp;
    static int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        insertInput();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, DFS(i, j)); // i, j부터 시작, 카운트는 1
            }
        }

        System.out.print(answer);
    }

    private static int DFS(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (forest[nx][ny] > forest[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
                }
            }
        }
        return dp[x][y];
    }

    private static void insertInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
