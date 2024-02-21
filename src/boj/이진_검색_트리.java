package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 이진_검색_트리 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 루트 노드
        Node node = new Node(Integer.parseInt(br.readLine()));

        // 하위 노드
        while (true) {
            String read = br.readLine();
            if (read == null || read.equals("")) {
                break;
            }

            int input = Integer.parseInt(read);
            node.insert(input);
        }

        post(node);

        System.out.println(sb);
    }

    // 후위 탐색
    private static void post(Node node) {
        if (node.left != null) {
            post(node.left);
        }
        if (node.right != null) {
            post(node.right);
        }
        sb.append(node.num).append("\n");
    }

    static class Node {

        int num;
        Node left = null;
        Node right = null;

        public Node(int num) {
            this.num = num;
        }

        void insert(int input) {
            // 삽입 노드가 현재 노드보다 작을 때(왼쪽 삽입)
            if (this.num > input) {
                if (this.left == null) {
                    this.left = new Node(input);
                } else {
                    this.left.insert(input);
                }
            }

            // 삽입 노드가 현재 노드보다 클 때(오른쪽 삽입)
            else {
                if (this.right == null) {
                    this.right = new Node(input);
                } else {
                    this.right.insert(input);
                }
            }

        }
    }
}
