package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int alreadyWire = Integer.parseInt(st.nextToken());
        int requiredWire = Integer.parseInt(st.nextToken());

        int[] wires = new int[alreadyWire];
        for (int i = 0; i < wires.length; i++) {
            wires[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(wires);

        long min = 1;
        long max = wires[wires.length - 1];
        long mid = 0;

        while (min <= max) {
            mid = (min + max) / 2;

            long count = 0;
            for (int wire : wires) {
                count += wire / mid;
            }

            if (count < requiredWire) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }

}
