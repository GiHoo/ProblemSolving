package programmers;

import java.util.Stack;

public class 프렌즈4블록 {

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // 2차원 배열 생성
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            String tmp = board[i];
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tmp.charAt(j);
            }
        }

        // 탐색 시작
        while (true) {
            boolean endSign = false;
            // 삭제 작업
            boolean[][] delete = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (matrix[i][j] != '0') {
                        char curr = matrix[i][j];
                        if (curr == matrix[i][j + 1] && curr == matrix[i + 1][j] && curr == matrix[i + 1][j + 1]) {
                            delete[i][j] = delete[i][j + 1] = delete[i + 1][j] = delete[i + 1][j + 1] = true;
                            endSign = true;
                        }
                    }
                }
            }

            // 삭제된 거 체크
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (delete[i][j]) {
                        matrix[i][j] = '0';
                        answer++;
                    }
                }
            }

            // 내리기 작업
            for (int i = 0; i < n; i++) {
                Stack<Character> stack = new Stack<>();

                for (int j = 0; j < m; j++) {
                    if (matrix[j][i] != '0') {
                        stack.push(matrix[j][i]);
                    }
                }

                int j = m -1;
                while (j >= 0) {
                    char tmp = '0';
                    if (!stack.isEmpty()) tmp = stack.pop();
                    matrix[j][i] = tmp;
                    j--;
                }
            }

            if (!endSign) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int m = 4;
        int n = 5;

        프렌즈4블록 solution = new 프렌즈4블록();
        System.out.println(solution.solution(m, n, board));

    }
}

/*

배열 생성 후 탐색

0, 0 부터 N-2, N-2까지 탐색

현재 칸 기준 4칸 탐색 시작 - 현재 칸, 우측 칸, 하단 칸, 우하단 칸

끝까지 탐색 후에 삭제 칸이 있다면 flag 바꾸기

칸 내리기 작업도 실행하기

 */
