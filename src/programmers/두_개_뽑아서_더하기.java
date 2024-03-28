package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 두_개_뽑아서_더하기 {

    public int[] solution(int[] numbers) {
        // 이중 for문을 통해 돌아서 더하기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }

        // 중복 제거 및 정렬
        Integer[] arr = list.stream().distinct().sorted().toArray(Integer[]::new);

        // 반환
        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }
}
