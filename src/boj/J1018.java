package boj;

import java.util.*;
import java.io.*;

public class J1018 {

    static int N;
    static int M;

    static int solution(String[] arr) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                for (int k = 0; k < 2; k++) {
                    char start = k == 0 ? 'W' : 'B';
                    int count = 0;
                    for (int n = i; n < i + 8; n++) {
                        for (int m = j; m < j + 8; m++) {
                            if (start != arr[n].charAt(m)) {
                                count++;
                            }
                            start = start == 'W' ? 'B' : 'W';
                        }
                        start = start == 'W' ? 'B' : 'W';
                    }
                    result = Math.min(result, count);
                    if (result == 0) {
                        return 0;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        System.out.println(solution(arr));

    }
}

