package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class AtoB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(A, 1));

        Set<Long> set = new HashSet<>();
        set.add(A);

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            long currTarget = node.target;
            int currCnt = node.cnt;

            if (currTarget <= B) {
                if (currTarget == B) {
                    answer = Integer.min(answer, currCnt);
                } else {
                    long next1 = currTarget * 2;
                    long next2 = Long.parseLong(currTarget + "1");

                    if (!set.contains(next1)) {
                        set.add(next1);
                        queue.add(new Node(next1, currCnt + 1));
                    }

                    if (!set.contains(next2)) {
                        set.add(next2);
                        queue.add(new Node(next2, currCnt + 1));
                    }
                }
            }
        }

        if (answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    private static class Node {

        long target;
        int cnt;

        public Node(long target, int cnt) {
            this.target = target;
            this.cnt = cnt;
        }
    }
}
