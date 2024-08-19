package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(arr, N, S);

        System.out.print(answer);
    }

    private static int solution(int[] arr, int N, int S) {
        int lt = 0;
        int rt = lt + 1;

        int answer = Integer.MAX_VALUE;
        int sum = (arr[lt] + arr[rt]);

        while (lt < rt && rt < N) {
            if (sum >= S) {
                int cnt = (rt - lt + 1);
                answer = Math.min(answer, cnt);

                sum -= arr[lt++];
            } else {
                sum += arr[++rt];
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] >= S) {
                answer = 1;
                break;
            }
        }

        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
}
