package programmers;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] damage = new int[board.length + 1][board[0].length + 1];
        for (int[] tmp : skill) {
            int type = tmp[0];
            int r1 = tmp[1], c1 = tmp[2], r2 = tmp[3], c2 = tmp[4];
            int degree = tmp[5];

            // 공격, 치유 상태 구분
            if (type == 1) degree = -degree;

            // 누적합을 위한 사전 세팅
            damage[r1][c1] += degree;
            damage[r1][c2 + 1] -= degree;
            damage[r2 + 1][c1] -= degree;
            damage[r2 + 1][c2 + 1] += degree;
        }

        // 가로 누적합 진행
        for (int i = 0; i < damage.length - 1; i++) {
            for (int j = 1; j < damage[0].length - 1; j++) {
                damage[i][j] += damage[i][j - 1];
            }
        }

        // 세로 누적합 진행
        for (int j = 0; j < damage[0].length - 1; j++) {
            for (int i = 1; i < damage.length - 1; i++) {
                damage[i][j] += damage[i - 1][j];
            }
        }

        // 누적합 배열과 기존 배열 비교 후 정답 산출
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + damage[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}

/*
12:50 ~ 14:11
파괴되지 않은 건물

- N * M 행렬 [row][column]
- 각 행에는 내구도 존재, 내구도는 0 이하가 되면 파괴
- 적은 공격하여 파괴, 아군은 회복을 통해 내구도 높이기

skill
- type, 1은 적군 공격, 2는 아군 회복
- r1, c1, r2, c2
- degree, 적군은 -degree, 아군은 +degree

board에 type별로 degree를 적용

범위를 설정해야 함
for (int i = r1; i <= r2; i++)
    for (int j = c1; j <= c2; j++)


----

효율서에서 뭉개지네
250,000(skill) * 1,000(row) * 1,000(column)
1,000,000, 400 이하로 해야 함

누적합으로 풀어야 한다.



 */
