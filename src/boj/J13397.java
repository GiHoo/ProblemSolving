package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J13397 {

    static int N;
    static int M;
    static int[] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N];

        int left = 0;
        int right = N - 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
            right = Integer.max(right, matrix[i]);
        }

        while(left < right) {
            int mid = (left + right)/2;
            if(solve(mid) <= M) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        System.out.println(right);
    }

    static int solve(int mid) {
        int cnt = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            min = Math.min(min, matrix[i]);
            max = Math.max(max, matrix[i]);
            if(max - min > mid) {
                cnt++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;
            }
        }
        return cnt;
    }
}

/*





 */
