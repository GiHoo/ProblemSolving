package programmers;

import java.util.HashMap;
import java.util.Map;

public class P14 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        int index = 0;
        for (String[] str : photo) {
            int num = 0;
            for (String target : str) {
                if(map.containsKey(target)) num += map.get(target);
            }
            answer[index++] = num;
        }
        return answer;
    }

    public static void main(String[] args) {
        P14 p14 = new P14();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        for (int i = 0; i < photo.length; i++) {
            System.out.print(p14.solution(name, yearning, photo)[i] + " ");
        }

    }
}


/*

사진 별로 추억 점수 매기기
사진 속에 나오는 인물의 그리움을 총 합쳐서 name - yearning 매칭



 */
