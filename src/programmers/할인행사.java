package programmers;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if (wantMap.equals(discountMap)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        할인행사 p = new 할인행사();

        System.out.println(p.solution(
                        new String[]{"banana", "apple", "rice", "pork", "pot"},
                        new int[]{3, 2, 2, 2, 1},
                        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
                ));
    }
}
