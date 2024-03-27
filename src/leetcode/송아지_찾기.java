package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지_찾기 {

    static int[] moves = {1, -1, 5};
    static int[] location = new int[10001];

    static int start;
    static int target;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        solution();

        System.out.print(answer);
    }

    private static void solution() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        location[start] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int curr = node.curr;
            int cnt = node.cnt;

            if (curr == target) {
                answer = Integer.min(answer, cnt);
                return;
            }

            for (int i = 0; i < moves.length; i++) {
                int new_curr = curr + moves[i];
                int new_cnt = cnt + 1;

                if (curr >= 1 && curr <= 10000 && location[new_curr] == 0) {
                    queue.add(new Node(new_curr, new_cnt));
                }
            }
        }
    }

    static class Node {

        int curr;
        int cnt;

        public Node(int curr, int cnt) {
            this.curr = curr;
            this.cnt = cnt;
        }
    }
}
