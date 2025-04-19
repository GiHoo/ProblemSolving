package programmers;

public class 보행자_천국 {
    int MOD = 20170805;
    static int answer = 0;
    static final int[][] mv = {{1, 0}, {0, 1}}; // 아래 0, 오른쪽 1

    public int solution(int m, int n, int[][] cityMap) {
        dfs(0, 0, 0, m, n, cityMap);

        return answer % MOD;
    }

    private void dfs(int currRow, int currCol, int direction, int m, int n, int[][] cityMap) {
        System.out.println();


        if (currRow == m - 1 && currCol == n - 1) {
            answer++;
            return;
        }

        // 현재 위치가 cityMap에서 어떤 상태인지 확인해야 함
        // 0이면 아래, 오른쪽 자유롭게 이동 가능
        // 1인 경우는 이동하지 않도록 return
        // 2면 이전 방향으로만 따라 가야 함

        int currState = cityMap[currRow][currCol];

        if (currState == 0) {
            // 자유롭게 이동
            for (int i = 0; i < mv.length; i++) {
                if (checkBoundary(currRow + mv[i][0], currCol + mv[i][1], m, n)) {
                    dfs(currRow + mv[i][0], currCol + mv[i][1], i, m, n, cityMap);
                }
            }
        } else if (currState == 1) {
            return;
        } else {
            if (checkBoundary(currRow + mv[direction][0], currCol + mv[direction][1], m, n)) {
                dfs(currRow + mv[direction][0], currCol + mv[direction][1], direction, m, n,
                        cityMap);
            }
        }
    }

    private static boolean checkBoundary(int row, int col, int m, int n) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}

/*

보행자 천국
15:20 ~

m * n 크기 cityMap
자동차는 오른쪽, 아래 로만 이동 가능
0: 자동차 자유롭게 이동 가능
1: 자동차 이동 불가능
2: 좌회전, 우회전 금지(직진만 가능)

최단거리가 아니니까, DFS로 모든 경우의 수 구하고 MOD로 나머지 리턴

아래, 오른쪽으로만 움직이니까 방문 배열을 확인할 필요 없음

일반적인 bfs 문제가 아님, dp로 풀어야 하는 문제
방향이 정해져 있으니, 그 방향으로 올 수 있는 것으로 채워야 함

 */
