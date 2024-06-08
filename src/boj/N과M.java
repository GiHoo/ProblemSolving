package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N과M {

    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> indexList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            indexList.add(i);
            DFS(1);
            indexList.remove(indexList.size() - 1);
            visited[i] = false;
        }

        System.out.println(sb);
    }

    static void DFS(int count) {
        if (count == M) {
            for (int index : indexList) {
                sb.append(numbers[index]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                indexList.add(i);
                DFS(count + 1);
                indexList.remove(indexList.size() - 1);
                visited[i] = false;
            }
        }
    }
}

/**
 * 수열을 먼저 정렬한다. depth를 0으로 하여 끝까지 갔을 때 확인한다.
 * <p>
 * depth와 count를 들고 간다.
 */
