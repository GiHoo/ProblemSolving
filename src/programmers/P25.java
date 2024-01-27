package programmers;

/**
 * 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 정확성: 100.0
 * 시간 복잡도: O(N^2)
 * 공간 복잡도: O(N^2)
 */

/*
양방향 그래프가 주어지고, 연결된 노드를 2차원 배열 conputers 로 전달

각 노드의 방문 여부를 확인하는 배열 visited 를 생성하고, 1번 노드부터 DFS 를 실행한다.
양방향 그래프이기 때문에 모든 배열을 다 순회할 필요 없다. (i, i 기준으로 위나 아래만 순회)
 */

class P25 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i, computers, n);
            }
        }

        return answer;
    }

    private static void DFS(int i, int[][] computers, int n) {
        visited[i] = true;

        for (int j = 0; j < n; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                DFS(j, computers, n);
            }
        }
    }
}
