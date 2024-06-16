package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 맥주_마시면서_걸어가기 {

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

            sb.append(canArriveFestival()).append("\n");
        }
    }

    private static String canArriveFestival() {
        return null;
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
