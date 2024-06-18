package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 맥주_마시면서_걸어가기 {

    private static final String canArrive = "happy";
    private static final String canNotArrive = "sad";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int store = Integer.parseInt(br.readLine());

            List<Node> list = new ArrayList<>();

            StringTokenizer st;
            for (int j = 0; j < store + 2; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y));
            }

            sb.append(canArriveFestival(list)).append("\n");
        }

        System.out.println(sb);
    }

    private static String canArriveFestival(List<Node> list) {
        int beer = 20;
        boolean arrive = true;

        Node end = list.get(list.size() - 1);
        int endX = end.x;
        int endY = end.y;

        Node start = list.get(0);
        list.remove(start);

        int startX = start.x;
        int startY = start.y;

        while (!list.isEmpty()) {
            Node next = list.get(0);
            list.remove(next);

            int nextX = next.x;
            int nextY = next.y;

            int distance = Math.abs(nextX - startX) + Math.abs(nextY - startY);
            int move = Math.floorDiv(distance, 50);

            System.out.println(distance + " " + move);

            if (move > beer) {
                arrive = false;
                break;
            }

            startX = nextX;
            startY = nextY;
        }

        return arrive ? canArrive : canNotArrive;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
