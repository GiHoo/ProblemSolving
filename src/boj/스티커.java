package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < TC; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] scores = new int[2][N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                scores[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                scores[1][j] = Integer.parseInt(st.nextToken());
            }

            if (N == 1) {
                System.out.println(Math.max(scores[0][0], scores[1][0]));
                continue;
            }

            int[][] dp = new int[2][N];
            dp[0][0] = scores[0][0];
            dp[1][0] = scores[1][0];

            if (N > 1) {
                dp[0][1] = scores[0][1] + dp[1][0];
                dp[1][1] = scores[1][1] + dp[0][0];
            }

            for (int k = 2; k < N; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + scores[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + scores[1][k];
            }

            System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
        }
    }
}
