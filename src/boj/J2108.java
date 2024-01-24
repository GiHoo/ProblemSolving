package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J2108 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int arithmeticMean = getArithmeticMean();
        int median = getMedian();
        int mode = getMode();
        int range = getRange();

        System.out.println(arithmeticMean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }

    private static int getArithmeticMean() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        return Math.round((float) sum / N);
    }

    private static int getMedian() {
        return arr[N / 2];
    }

    private static int getMode() {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = 0;
        for (int key : map.values()) {
            max = Integer.max(max, key);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == max) list.add(key);
        }

        Collections.sort(list);

        int answer;
        if (list.size() == 1) answer = list.get(0);
        else answer = list.get(1);

        return answer;
    }

    private static int getRange() {
        if (N == 1) return 0;
        else return arr[N - 1] - arr[0];
    }
}

/*

통계학

 */
