package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1436 {

    static int N;
    static int start = 666;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count = 1;

        while (count != N) {
            start++;
            if (String.valueOf(start).contains("666")) {
                count++;
            }
        }

        System.out.println(start);
    }
}
