package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J18110 {

    static int N;
    static int[] opinions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        opinions = new int[N];

        for (int i = 0; i < N; i++) {
            opinions[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(opinions);

        int except = getExcept();

        int sum = 0;
        for (int i = except; i < N - except; i++) {
            sum += opinions[i];
        }

        int answer = Math.round((float) sum / (N - except * 2));

        System.out.println(answer);
    }

    private static int getExcept() {
        return Math.round((float) (N * 15) / 100);
    }
}

/*

18110 solved.ac

 */
