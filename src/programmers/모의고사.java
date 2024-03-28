package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

    static int[] person1 = {1, 2, 3, 4, 5}; // 5번 마다 반복
    static int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8번 마다 반복
    static int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10번 마다 반복

    public int[] solution(int[] answers) {
        // 각 멤버의 찍은 점수를 가져온다.
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % 5]) scores[0]++;
            if (answers[i] == person2[i % 8]) scores[1]++;
            if (answers[i] == person3[i % 10]) scores[2]++;
        }

        // 최대 점수를 확인한다.
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 최대 점수인 사람들 확인
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (maxScore == scores[i]) answer.add(i + 1);
        }

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
