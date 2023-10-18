package boj;

import java.util.*;
import java.io.*;

public class J1431 {

    private static List<String> serials = new ArrayList<>();

    public static void solution() {
        Collections.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int compared1 = s1.length() - s2.length();
                if (compared1 == 0) {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (int i = 0; i < s1.length(); i++) {
                        if (Character.isDigit(s1.charAt(i))) sum1 += s1.charAt(i) - '0';
                    }
                    for (int i = 0; i < s2.length(); i++) {
                        if (Character.isDigit(s2.charAt(i))) sum2 += s2.charAt(i) - '0';
                    }

                    if (sum1 == sum2) {
                        return s1.compareTo(s2);
                    } else {
                        return Integer.compare(sum1, sum2);
                    }
                }
                return compared1;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            serials.add(br.readLine());
        }

        solution();

        for (int i = 0; i < N; i++) {
            System.out.println(serials.get(i));
        }
    }
}
