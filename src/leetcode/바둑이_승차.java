package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바둑이_승차 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] dogs = new int[N];
        for (int i = 0; i < N; i++) {
            dogs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("hello world!!!");
    }
}
