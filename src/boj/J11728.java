package boj;

import java.util.*;
import java.io.*;

public class J11728 {
    static StringBuilder sb = new StringBuilder();
    public static void solution(int[] A, int[] B) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            list.add(B[i]);
        }

        Collections.sort(list);

        for (int i=0; i < list.size(); i++) {
            if(i == list.size() - 1) sb.append(list.get(i));
            else sb.append(list.get(i)).append(" ");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        solution(A, B);

        System.out.println(sb);
    }
}
