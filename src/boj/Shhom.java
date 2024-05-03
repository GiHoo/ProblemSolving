package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Shhom {

    static int N;
    static int[] X;
    static int[] S;
    static boolean[] visited;
    static boolean isAnswer = false;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        X = new int[N];
        visited = new boolean[N];
        S = new int[N * 2];

        for (int i = 0; i < 2 * N; i++) {
            S[i] = -1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(X);

        dfs(0);

        System.out.print((isAnswer) ? sb : -1);
    }

    private static void dfs(int depth) {
        if (!isAnswer) {

            if (depth == 2 * N) {
                for (int i = 0; i < 2 * N; i++) {
                    if (S[i] == -1) return;
                }

                isAnswer = true;
                for (int i = 0; i < 2 * N; i++) {
                    sb.append(S[i]).append(" ");
                }
                return;
            }

            if (S[depth] != -1) {
                dfs(depth+1);
            }

            for (int i = 0; i < N; i++) {
                if (depth + X[i] + 1 < 2 * N && !visited[i] && S[depth] == -1 && S[depth + X[i] + 1] == -1) {
                    visited[i] = true;
                    S[depth] = S[depth + X[i] + 1] = X[i];
                    dfs(depth + 1);
                    S[depth] = S[depth + X[i] + 1] = -1;
                    visited[i] = false;
                }
            }

        }
    }
}
