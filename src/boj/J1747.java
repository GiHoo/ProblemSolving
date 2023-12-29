package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1747 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solution();
    }

    private static void solution() {

        int answer = N;

        while (!isPalindrome(answer) || !isPrime(answer)) {
            answer++;
        }

        System.out.print(answer);
    }

    private static boolean isPalindrome(int target) {
        String str = String.valueOf(target);

        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (str.charAt(lt) != str.charAt(rt)) return false;
            lt++;
            rt--;
        }

        return true;
    }

    private static boolean isPrime(int target) {
        if (target == 1) return false;

        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (target % i == 0) return false;
        }

        return true;
    }
}


