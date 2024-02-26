package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인간_컴퓨터_상호작용 {

    static int[][] dp;
    static String input;
    static int alphabet = 26;
    static int tc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine();
        tc = Integer.parseInt(br.readLine());

        init();

        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j < alphabet; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        StringTokenizer st;
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());

            char target = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[end + 1][target - 'a'] - dp[start][target - 'a']).append("\n");
        }

        System.out.println(sb);
    }

    private static void init() {
        dp = new int[input.length() + 1][alphabet];

        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j < alphabet; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][input.charAt(i - 1) - 'a'] += 1;
        }
    }
}
