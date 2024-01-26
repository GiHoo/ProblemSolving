package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 1; i < N; i++) {
            int target = i;
            int sum = i;

            while (target != 0) {
                sum += (target % 10);
                target /= 10;
            }

            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}

/*

2231 분해합

 */
