package boj;

import java.util.*;
import java.io.*;

public class J11053 {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (max < A[i] && !map.containsKey(A[i])) {
                max = Math.max(max, A[i]);
            }
        }

//        System.out.print(count);
    }
}
