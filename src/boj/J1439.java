package boj;

import java.io.*;
//단어 뒤집기
public class J1439 {
    public static String solution(String input) {
        String[] arr = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            char[] carr = arr[i].toCharArray();
            int start = 0;
            int end = carr.length -1;
            while (start < end) {
                char tmp = carr[start];
                carr[start] = carr[end];
                carr[end] = tmp;

                start++;
                end--;
            }
            if(i == arr.length -1) sb.append(carr);
            else sb.append(carr).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            System.out.println(solution(input));
        }
    }
}
