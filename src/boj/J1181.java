package boj;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class J1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        list.sort(((o1, o2) -> {
            int compare = o1.length() - o2.length();
            if (compare == 0) {
                return o1.compareTo(o2);
            } else return compare;
        }));

        List<String> answer = list.stream().distinct().collect(Collectors.toList());

        for (String s : answer) {
            System.out.println(s);
        }
    }
}

