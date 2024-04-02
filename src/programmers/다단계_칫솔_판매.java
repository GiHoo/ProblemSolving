package programmers;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> relation = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            relation.put(enroll[i], referral[i]);
        }

        Map<String, Integer> sells = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            // 현재 판매자 이름, 판매 금액
            String curName = seller[i];
            int money = amount[i] * 100;

            while (money > 0 && !curName.equals("-")) {
                sells.put(curName, sells.getOrDefault(curName, 0) + money - money / 10);
                curName = relation.get(curName);
                money /= 10;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sells.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}
