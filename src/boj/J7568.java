package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J7568 {

    static int N;
    static int[][] weightAndHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        weightAndHeight = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            weightAndHeight[i][0] = Integer.parseInt(st.nextToken());
            weightAndHeight[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int weight = weightAndHeight[i][0];
            int height = weightAndHeight[i][1];

            int grade = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                int comparisonW = weightAndHeight[j][0];
                int comparisonH = weightAndHeight[j][1];

                if (weight >= comparisonW || height >= comparisonH) {
                    continue;
                } else {
                    grade++;
                }
            }

            if (i == N - 1) {
                sb.append(grade);
            } else {
                sb.append(grade).append(" ");
            }
        }

        System.out.println(sb);
    }
}

/*

7568 덩치

 */
