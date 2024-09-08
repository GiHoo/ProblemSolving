package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다각형의면적 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates[i] = new Coordinate(x, y);
        }

        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < N; i++) {
            int x1 = coordinates[i].x;
            int y1 = coordinates[i].y;

            int x2 = coordinates[(i + 1) % N].x;
            int y2 = coordinates[(i + 1) % N].y;

            sum1 += (x1 * y2);
            sum2 += (y1 * x2);
        }

        double area = Math.abs(sum1 - sum2) / 2.0;

        System.out.printf("%.1f%n", area);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
