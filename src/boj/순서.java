package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class N과M12 {

    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        DFS(0, 0);

        System.out.println(sb);
    }

    private static void DFS(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }

            sb.append("\n");

            return;
        }

        int last = 0; // 중복된 숫자 체크를 위한 변수
        for (int i = start; i < N; i++) {
            if (last != arr[i]) { // 이전에 사용한 숫자와 다를 때만 진행
                result[depth] = arr[i];
                last = arr[i]; // 현재 사용한 숫자로 갱신
                DFS(depth + 1, i); // i를 넘겨 비내림차순 보장
            }
        }
    }
}
