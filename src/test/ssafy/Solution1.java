package test.ssafy;

import java.util.*;

class Solution1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            List<Integer> A = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int target = sc.nextInt();
                A.add(target);
            }

            int result = 0;

            while (true) {
                boolean flag = checkValidation(A);
                if (flag || result >= 10000) break;

                int target = A.get(K - 1);
                A.remove(0);
                A.add(target);

                result++;
            }

            if (result >= 10000) result = -1;

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static boolean checkValidation(List<Integer> A) {
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) != A.get(i + 1)) return false;
        }

        return true;
    }
}
