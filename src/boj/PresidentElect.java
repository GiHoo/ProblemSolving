package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class PresidentElect {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int memberCount = Integer.parseInt(br.readLine());

        List<Integer>[] adjList = new ArrayList[memberCount + 1];
        for (int i = 0; i <= memberCount; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());

            int memberA = Integer.parseInt(st.nextToken());
            int memberB = Integer.parseInt(st.nextToken());

            if (memberA == -1)
                break;
            else {
                adjList[memberA].add(memberB);
                adjList[memberB].add(memberA);
            }
        }
        br.close();

        for (List<Integer> list : adjList) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
