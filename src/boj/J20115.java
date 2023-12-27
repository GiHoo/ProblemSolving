package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J20115 {

    static int drinkCount;
    static double[] drinks;
    static double answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        drinkCount = Integer.parseInt(br.readLine());
        drinks = new double[drinkCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < drinkCount; i++) {
            drinks[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(drinks);

        for (int i = 0; i < drinkCount; i++) {
            if (i != drinkCount - 1) {
                drinks[i] /= 2;
            }
            answer += drinks[i];
        }

        System.out.println(answer);
    }
}

