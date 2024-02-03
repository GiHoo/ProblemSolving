package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J26007 {

    static int N; // 라운드에 참여한 횟수
    static int[] A; // 라운에 참여한 후 레이팅 증감 수열
    static int M; // 쿼리 수
    static int K; // 목표 레이팅 점수
    static int X; // 초기 레이팅 점수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        A[0] = X;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = (A[i - 1] + Integer.parseInt(st.nextToken()));
        }

        int[] isLower = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            if (A[i] < K) cnt++;
            isLower[i] = isLower[i - 1] + cnt;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) - 1;

            int cnt = isLower[end] - isLower[start - 1];

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}

/*

Codepowers

 */
