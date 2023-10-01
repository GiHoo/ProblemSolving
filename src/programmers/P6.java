package programmers;

public class P6 {
    public int solution(int[][] sizes) {
        int garo = 0;
        int sero = 0;
        for(int i=0; i<sizes.length; i++) {
            int max = Integer.max(sizes[i][0], sizes[i][1]);
            int min = Integer.min(sizes[i][0], sizes[i][1]);
            garo = Integer.max(garo, max);
            sero = Integer.max(sero, min);
        }
        return garo*sero;
    }

    public static void main(String[] args) {
        System.out.println(new P6().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80,40}}));
    }
}
