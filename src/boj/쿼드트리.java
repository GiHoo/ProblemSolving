package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {

    static int N;
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.charAt(j) - '0';
            }
        }

        divide(0, 0, N);

        System.out.println(sb);
    }

    public static void divide(int x, int y, int size) {
        if (isPossible(x, y, size)) {
            sb.append(matrix[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        // 왼위, 오위, 왼아, 오아
        divide(x, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y, newSize);
        divide(x + newSize, y + newSize, newSize);

        sb.append(')');


    }

    private static boolean isPossible(int x, int y, int size) {
        int value = matrix[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
