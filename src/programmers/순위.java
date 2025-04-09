package programmers;

import java.util.*;

public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] matches = new int[n + 1][n + 1];

        for (int[] result : results) {
            matches[result[0]][result[1]] = 1;
            matches[result[1]][result[0]] = -1;
        }

        // 플로이드 워셜 -> ik - ij jk, 노드 간 관계 구하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (matches[i][j] == 1 && matches[j][k] == 1) {
                        matches[i][k] = 1;
                        matches[k][i] = -1;
                    }

                    if (matches[i][j] == -1 && matches[j][k] == -1) {
                        matches[i][k] = -1;
                        matches[k][i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = n - 1;
            for (int j = 1; j <= n; j++) {
                if (matches[i][j] != 0) cnt--;
            }

            if (cnt == 0) answer++;
        }

        return answer;
    }
}

/*
순위

1 ~ N 번호의 권투 선수가 1:1 대결

result[A, B] -> A선수가 B를 이김

알려진 결과로 일단 그래프 생성

N명일 때 win, lose 카운트 합이 N - 1일 때 확정

cnt[n][win, lose]

1: 2 0
2: 1 3
3: 2 1
4: 3 0
5  0 4

matches[N + 1][N + 1] -> N명의 경기 결과를 담음
0 모름, 1 승리, 2 패배

dfs하면서 prev를 담으면서 가면서 다 배열에 저장

------
실패.
모든 결과를 저장하려고 보니 O(N × (N + E)) 이상

플로이드-워셜 알고리즘 수행, O(N^3)
- 모든 노드 간 관계(승패, 최단거리) 구할 때 사용


 */
