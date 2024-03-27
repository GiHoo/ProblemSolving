package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 합이_같은_부분집합 {

    static int N;
    static int[] numbers;
    static int sum = 0;
    static String answer = "NO";

    public static void main(String[] args) throws IOException {
        init();

        solution();

        System.out.print(answer);
    }

    private static void solution() {
        DFS(0, 0);
        DFS(0, numbers[0]);
    }

    private static void DFS(int index, int parts) {
        if (sum == sum - parts && parts != 0) {
            answer = "YES";
            return;
        }

        if (index < N - 1) {
            DFS(index + 1, parts);
            DFS(index + 1, parts + numbers[index + 1]);
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
            sum += numbers[i];
        }
    }
}
