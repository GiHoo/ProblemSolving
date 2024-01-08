package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int triangle_size = Integer.parseInt(br.readLine());
        int[][] triangle = new int[triangle_size][triangle_size];

        StringTokenizer st;
        for (int i = 0; i < triangle_size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = triangle_size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.max(triangle[i][j] + triangle[i + 1][j], triangle[i][j] + triangle[i + 1][j + 1]);
            }
        }

        System.out.println(triangle[0][0]);
    }
}
