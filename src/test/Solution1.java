package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = -1;

            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] answerCode = new int[N];
            int[] lateCode = new int[M];

            for (int i = 0; i < N; i++) {
                answerCode[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                lateCode[i] = sc.nextInt();
            }

            Arrays.sort(answerCode);
            Arrays.sort(lateCode);

            int curr = answerCode[N - 1];
            int max = lateCode[0];

            // 정답 코드를 만족하는 값이 느린 코드를 만족하는 선에서 작용
            while (curr < max) {
                // 현재 값이 정답 코드를 만족하는지 확인
                double half = curr / 2;
                boolean isHalf = false;
                for (int i = 0; i < N; i++) {
                    if (answerCode[i] <= half) {
                        isHalf = true;
                        break;
                    }
                }

                if (isHalf) {
                    answer = curr;
                    break;
                } else {
                    curr += 1;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }

        sc.close();
    }
}

/*

문제의 시간 제한

N개의 정답 코드 실행 시간
M개의 느린 코드 실행 시간

조건
(1) 모든 정답 코드는 시간 제한 이하에 실행되어야 한다.
(2) 모든 느린 코드는 시간 제한을 초과해야 한다.
(3) 정답 코드 중 적어도 하나는 시간 제한의 0.5배 이하에 실행되어야 한다.
위 세 조건을 모두 만족하는 시간 제한 중 최솟값을 구하라. 불가능한 경우는 -1을 제시하라.


정답 코드와 느린 코드를 분리해서 하자

정답 코드 정렬
2 2 3 4
min   max
1
4 3
2 3 4 2
6 8 7

 */
