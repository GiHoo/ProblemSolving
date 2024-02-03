package boj;

import java.util.Scanner;

public class J2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] fib = new long[N+2];

        fib[1] = 1;
        fib[2] = 1;

        fibo(N, fib);

        System.out.print(fib[N]);
    }

    private static void fibo(int N, long[] fib) {
        for (int i = 1; i <= N - 2; i++) {
            fib[i + 2] = fib[i] + fib[i + 1];
        }
    }
}
