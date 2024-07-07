package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    static int start, end;
    static Queue<Node> queue = new LinkedList<>();
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        queue.add(new Node(start));
        visited.add(start);

        int answer = 0;
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            if (currNode.currentPosition == end) {
                answer = currNode.spendTime;
                break;
            }

            currNode.move();
        }

        System.out.println(answer);
    }

    static class Node {
        int currentPosition;
        int spendTime;

        public Node(int currentPosition) {
            this.currentPosition = currentPosition;
            this.spendTime = 0;
        }

        public Node(int currentPosition, int spendTime) {
            this.currentPosition = currentPosition;
            this.spendTime = spendTime;
        }

        public void move() {
            moveLeft();
            moveRight();
            teleport();
        }

        private void moveLeft() {
            int nextPosition = this.currentPosition - 1;
            if (canMove(nextPosition)) {
                visited.add(nextPosition);
                queue.add(new Node(nextPosition, this.spendTime + 1));
            }
        }

        private void moveRight() {
            int nextPosition = this.currentPosition + 1;
            if (canMove(nextPosition)) {
                visited.add(nextPosition);
                queue.add(new Node(nextPosition, this.spendTime + 1));
            }
        }

        private void teleport() {
            int nextPosition = this.currentPosition * 2;
            if (canMove(nextPosition)) {
                visited.add(nextPosition);
                queue.add(new Node(nextPosition, this.spendTime + 1));
            }
        }

        private boolean canMove(int nextPosition) {
            return (nextPosition >= 0 && nextPosition <= 100000) && (!visited.contains(nextPosition));
        }
    }
}
