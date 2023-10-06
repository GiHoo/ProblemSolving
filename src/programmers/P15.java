package programmers;

import java.util.*;

public class P15 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> hall = new ArrayList<>();
        for(int i=0; i<score.length; i++) {
            hall.add(score[i]);

            Collections.sort(hall);

            if(hall.size() > k) hall.remove(0);
            answer[i] = hall.get(0);
        }
        return answer;
    }

    public static void main(String[] args) {
        P15 p15 = new P15();
        int key = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        for (int i = 0; i < score.length; i++) {
            System.out.print(p15.solution(key, score)[i]);
        }
    }
}

/*

매일 1명의 가수가 노래를 부르고 시청자 문자 투표

가장 점수가 낮은 3명을 보관하여 점수가 낮은 1명을 보관

 */
