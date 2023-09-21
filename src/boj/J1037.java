package boj;

import java.util.*;
import java.io.*;

public class J1037 {
    public static int solution(int[] arr) {
        int answer;
        Arrays.sort(arr);
        if(arr.length==1) {
          answer = (arr[0]*arr[0]);
        } else {
            answer = (arr[0] * arr[arr.length - 1]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr));
    }
}
