package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int increase = 6;

        int cnt = 0;

        while (N > 0) {
            cnt++;

            N -= start;

            if (start == 1) {
                start *= increase;
            } else {
                start += increase;
            }
        }

        System.out.println(cnt);
    }
}

/*

2292 벌집

 */
