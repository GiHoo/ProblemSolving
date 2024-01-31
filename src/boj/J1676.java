package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1676 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.print(getAnswer());

    }

    private static int getAnswer() {
        int count = 0;

        while (N >= 5) {
            count += N / 5;
            N /= 5;
        }

        return count;
    }
}

/*

1676: 팩토리어의 개수


 */
