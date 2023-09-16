package barking.x1;

import java.util.*;
import java.io.*;

public class J2577 {
    private static String solution(int A, int B, int C) {
        StringBuffer sb = new StringBuffer();
        int[] arr = new int[10];
        int abc = A*B*C;
        while (abc>0) {
            int target = abc%10;
            arr[target]++;
            abc /= 10;
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i!=arr.length-1) sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        System.out.println(solution(A, B, C));
    }
}
