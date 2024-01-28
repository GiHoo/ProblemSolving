package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 링크: https://www.acmicpc.net/problem/9095
 * 메모리: 14132 KB
 * 시간: 124 ms
 * 시간 복잡도: O(N)
 * 공간 복잡도: O(N)
 */

/*
처음에는 조금 헷갈렸다.
1, 2, 3의 개수를 고정하고 이를 가지고 풀어야 겠다는 생각은 했었는데, 그 이후의 사고를 하지 못했음
그래서 4, 5, 6까지의 갯수를 비교해봤는데 7 13 24가 나왔다.
점화식을 유도할 수 있었고 해답을 얻어내긴 했다.

dp is so hard...
 */

public class J9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11]; // 11보다 작은 양수, 1 ~ 10

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
