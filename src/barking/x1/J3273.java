package barking.x1;

import java.util.*;
import java.io.*;

public class J3273 {
    private static int solution(int[] arr, int X) {
        int answer = 0;

        Arrays.sort(arr);
        int lt = 0;
        int rt = arr.length-1;
        while (lt < rt) {
            if(X == (arr[lt] + arr[rt])) {
                answer++;
                lt++;
                rt--;
            } else if (X < (arr[lt] + arr[rt])) {
                rt--;
            }
            else {
                lt++;
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        System.out.println(solution(arr, X));

    }
}
