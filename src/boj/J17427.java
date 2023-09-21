package boj;

import java.io.*;

public class J17427 {
    public static long solution(int input) {
        long fx = getDivisorSum(input);
        return fx;
    }

    public static long getDivisorSum(int x) {
        long fx = 0;
        for (int i = 1; i <= x; i++) {
            fx += (long) (x / i) *i;
        }
        return fx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(solution(input));
    }
}