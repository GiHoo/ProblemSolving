package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WhoIsWinner {
    static int HI_WIN = 0;
    static int ARC_WIN = 0;
    static int DRAW = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // HI
        int M = Integer.parseInt(st.nextToken()); // ARC

        int[] HI = new int[N];
        int[] ARC = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            HI[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ARC[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(HI);
        Arrays.sort(ARC);

        for (int i = 0; i < HI.length; i++) {
            int target = HI[i];

            int start = 0;
            int end = ARC[ARC.length - 1];
            int mid = (start + end) / 2;

            while (start < end) {
                if (target == mid) {
                    DRAW++;
                    break;
                } else if (target < mid) {
                    start = mid;
                    
                } else {

                }




            }
        }
    }
}

/**
 *
 * NlongN
 *
 */
