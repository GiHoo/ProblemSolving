package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = Integer.MAX_VALUE;
        int[] answer = new int[2];

        int lt = 0;
        int rt = N - 1;
        while (lt < rt) {
            int sum = solutions[lt] + solutions[rt];

            if (maxValue > Math.abs(sum)) {
                maxValue = Math.abs(sum);

                answer[0] = solutions[lt];
                answer[1] = solutions[rt];
            }

            if (sum == 0) {
                break;
            } else if (sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
