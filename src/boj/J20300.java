package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J20300 {

    static int N;
    static long[] muscleLossArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        muscleLossArray = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            muscleLossArray[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(muscleLossArray);

        long muscleLoss = getMuscleLoss();

        System.out.println(muscleLoss);
    }

    private static long getMuscleLoss() {
        long muscleLoss;

        long tmp = 0;
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                tmp = Long.max(tmp, muscleLossArray[i] + muscleLossArray[N - 1 - i]);
            }
        } else {
            for (int i = 0; i < N / 2; i++) {
                tmp = Long.max(tmp, muscleLossArray[i] + muscleLossArray[N - 2 - i]);
            }
            tmp = Long.max(tmp, muscleLossArray[N - 1]);
        }
        muscleLoss = tmp;

        return muscleLoss;
    }
}

/*

20300 서강헬스맨

 */
