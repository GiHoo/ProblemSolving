package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 암호만들기 {

    static int L, C;
    static String[] words;
    static Map<Character, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);

        words = new String[C];
        words = br.readLine().split(" ");

        Arrays.sort(words);

        DFS(0, "");

        System.out.println(sb);
    }

    private static void DFS(int depth, String password) {
        if (depth == C) {
            if (password.length() == L && validatePassword(password)) {
                sb.append(password).append("\n");
            }
            return;
        }

        if (password.length() < L) {
            DFS(depth + 1, password + words[depth]);
        }

        DFS(depth + 1, password);
    }

    private static boolean validatePassword(String password) {
        int cnt = 0;
        for (int i = 0; i < password.length(); i++) {
            if (map.containsKey(password.charAt(i))) {
                cnt++;
            }
        }

        return (cnt >= 1) && ((password.length() - cnt) >= 2);
    }
}

