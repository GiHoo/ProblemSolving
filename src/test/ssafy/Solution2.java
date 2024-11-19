package test.ssafy;

import java.util.*;

class Solution2 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            int lt = 0;
            int rt = N - 1;
            int maxSum = Integer.MIN_VALUE;
            while (lt + K - 1 < rt - K + 1) {
                int ltSum = getSum(lt, lt + K -1, A);
                int rtSum = getSum(rt - K + 1, rt, A);
                maxSum = Integer.max(maxSum, ltSum + rtSum);

                if (ltSum <= rtSum) {
                    lt++;
                } else {
                    rt--;
                }
            }

            System.out.println("#" + test_case + " " + maxSum);
        }

        sc.close();
    }

    private static int getSum(int start, int end, int[] A) {
        int sum = 0;
        for (int i = start; i <= end; i++) sum += A[i];
        return sum;
    }
}

/*

3
6 2
2 4 3 -4 6 1
4 1
3 4 5 1
4 2
-2 -3 -4 -1

 */
