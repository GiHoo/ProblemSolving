package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트 {

    static int N;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;  // 사이클이 확정된 노드를 추적하기 위한 배열
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            N = Integer.parseInt(br.readLine());
            students = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    DFS(j);
                }
            }

            System.out.println(N - cnt);
        }
    }

    private static void DFS(int current) {
        visited[current] = true;
        int next = students[current];

        if (!visited[next]) { // 다음 노드가 방문되지 않았다면 DFS 호출
            DFS(next);
        } else if (!finished[next]) { // 이미 방문했지만, 사이클이 완료되지 않았다면
            // 사이클이 발생
            cnt++;
            for (int i = next; i != current; i = students[i]) {
                cnt++;
            }
        }

        // 현재 노드에 대한 DFS 완료 표시
        finished[current] = true;
    }
}
