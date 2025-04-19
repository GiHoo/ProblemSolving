package programmers;

public class 보행자_천국 {

    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        final int GO = 0;
        final int WALL = 1;
        final int STRAIGHT = 2;

        final int FROM_UP = 0;
        final int FROM_LEFT = 1;

        // dp 설정 왼쪽에서 올 수 있는 것과 위에서 올 수 있는 것으로 나눔
        int[][][] dp = new int[m][n][2];

        for (int row = 0; row < m; row++) {
            if (cityMap[row][0] == WALL) {
                break;
            } else {
                dp[row][0][FROM_UP] = 1;
            }
        }

        for (int col = 0; col < n; col++) {
            if (cityMap[0][col] == WALL) {
                break;
            } else {
                dp[0][col][FROM_LEFT] = 1;
            }
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (cityMap[row][col] == WALL) {
                    continue;
                }

                int up = dp[row - 1][col][FROM_UP];
                if (cityMap[row - 1][col] == GO) {
                    up = (up + dp[row - 1][col][FROM_LEFT]) % MOD;
                }

                int left = dp[row][col - 1][FROM_LEFT];
                if (cityMap[row][col - 1] == GO) {
                    left = (left + dp[row][col - 1][FROM_UP]) % MOD;
                }


                dp[row][col][FROM_UP] = up;
                dp[row][col][FROM_LEFT] = left;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j][0] + " " + dp[i][j][1] + "  ");
            }
            System.out.println();
        }

        return (dp[m - 1][n - 1][FROM_LEFT] + dp[m - 1][n - 1][FROM_UP]) % MOD;
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
