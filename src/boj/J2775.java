package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] apartment = new int[15][15];

        for(int i = 0; i < 15; i++) {
            apartment[i][1] = 1;	// i층 1호
            apartment[0][i] = i;	// 0층 i호
        }


        for(int i = 1; i < 15; i ++) {	// 1층부터 14층까지

            for(int j = 2; j < 15; j++) {	// 2호부터 14호까지
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(apartment[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}

/*

2775 부녀회장이 될테야

 */
