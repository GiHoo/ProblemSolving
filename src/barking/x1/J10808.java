package barking.x1;

import java.util.*;
import java.io.*;

public class J10808 {
    private static String solution(String str) {
        int[] answer = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - 'a';
            answer[a]++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.print(solution(str));
    }
}
