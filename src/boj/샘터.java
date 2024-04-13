package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 샘터 {

    static long[] moves = {-1, 1}; // 좌, 우 이동을 위한 배열
    static int N;
    static int K;
    static Queue<Node> queue = new LinkedList<>();
    static Set<Long> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(st.nextToken());
            queue.add(new Node(input, input));
            visited.add(input);
        }

        System.out.print(solution());
    }

    private static long solution() {
        long unhappiness = 0;
        long house_count = 0;

        while (!queue.isEmpty() && house_count < K) {
            Node node = queue.poll();
            long well = node.well;
            long house = node.house;

            for (long move : moves) {
                long new_house = house + move;
                if (!visited.contains(new_house) && house_count < K) {
                    queue.add(new Node(well, new_house));
                    visited.add(new_house);
                    unhappiness += Math.abs(well - new_house);
                    house_count++;
                }
            }
        }

        return unhappiness;
    }

    static class Node {
        long well;
        long house;

        public Node(long well, long house) {
            this.well = well;
            this.house = house;
        }
    }
}
