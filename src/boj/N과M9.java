package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N과M9 {

    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        DFS(0);
        System.out.println(sb);
    }

    private static void DFS(int depth) {
        if (depth == M) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < M; i++) {
                temp.append(result[i]).append(" ");
            }

            String str = temp.toString();
            if (!set.contains(str)) {
                set.add(str);
                sb.append(str).append("\n");
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
