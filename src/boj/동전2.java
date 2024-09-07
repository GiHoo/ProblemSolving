package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 동전2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            coins[i] = input;

            set.add(input);
            queue.add(new Node(input, 1));
        }

        int answer = -1;
        while (!queue.isEmpty()) {
            Node coin = queue.poll();

            if (coin.sum == K) {
                answer = coin.cnt;
                break;
            }

            for (int i = 0; i < N; i++) {
                int newSum = coin.sum + coins[i];
                if (newSum <= K && !set.contains(newSum)) { // K를 넘지 않는 경우에만 추가
                    set.add(newSum);
                    queue.add(new Node(newSum, coin.cnt + 1));
                }
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int sum;
        int cnt;

        public Node(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
    }
}
