package boj;

import java.io.*;

public class J4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();
        while((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            int step = 1;
            while((step%num)!=0) {
                step = ((step*10) + 1);
            }
            int cnt = String.valueOf(step).length();
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}

