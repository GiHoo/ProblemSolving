package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J15468 {

    static int[][] dist;    // 거리 측정 배열
    static boolean[][][] visit;    // 벽을 부순 여부에 따라 방문 여부 기록
    static int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2]; //

        StringTokenizer st;
        for (int i =1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }


    }
}
