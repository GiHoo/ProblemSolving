package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N과M9 {

    static int N, M;
    static String[] arr;
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N];

        arr = br.readLine().split(" ");

        Arrays.sort(arr);

        DFS(0, "");

        System.out.println(sb);
    }

    private static void DFS(int depth, String sequence) {
        if (depth == N) {
            if (!map.containsKey(sequence) && sequence.length() == M) {
                map.put(sequence, map.getOrDefault(sequence, 0) + 1);

                for (int i = 0; i < sequence.length(); i++) {
                    sb.append(sequence.charAt(i)).append(" ");
                }
                sb.append("\n");
            }

            return;
        }

//        System.out.println(depth + " " + sequence);
        if (sequence.length() < M) {
            DFS(depth + 1, sequence + arr[depth]);
        }

        DFS(depth + 1, sequence);
    }
}
