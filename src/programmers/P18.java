package programmers;

import java.util.Arrays;

public class P18 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int[] tscore = new int[score.length];
        for (int i = 0; i < tscore.length; i++) {
            tscore[i] = score[score.length - 1 - i];
        }
        int index = 0;
        for(int i=0; i<tscore.length/m; i++) {
            int min = 10; // 최대점보다 1높게
            for(int j=index; j<index+m; j++) {
                min = Integer.min(min, tscore[j]);
            }
            answer += (min*m);
            index += m;
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(new P18().solution(k, m, score));
    }
}
