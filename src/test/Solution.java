package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] positions = new int[N];
            for (int i = 0; i < N; i++) {
                positions[i] = sc.nextInt();
            }

            Arrays.sort(positions);

            int answer = Integer.MAX_VALUE;

            for (int i = 0; i <= N - K; i++) {

                int idx = 0;
                int[] tmp = new int[K];
                for (int j = i; j < i + K; j++) {
                    tmp[idx++] = positions[j];
                }

                int sum = 0;
                for (int j = 0; j < K - 1; j++) {
                    for (int k = j +1; k < K; k++) {
                        sum += Math.abs(tmp[j] - tmp[k]);
                    }
                }

                answer = Math.min(answer, sum);
            }

            System.out.println("#" + test_case + " " + answer);
        }

        sc.close();
    }
}

/*

N개의 점이 x축 좌표 위에 존재
점들 중 K개를 골라 K개의 점들 사이에 존재하는 모든 가능한 쌍의 거리의 합이 최소가 되는 점을 선택, 최소거리 구하기

N개 중 K개를 고르고, K개들 사이의 거리를 구하기

 */
