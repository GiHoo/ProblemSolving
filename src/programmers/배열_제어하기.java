package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class 배열_제어하기 {

    public static int[] solution(int[] arr) {
        Integer[] narr = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(narr, Collections.reverseOrder());

        return Arrays.stream(narr).mapToInt(Integer::intValue).toArray();
    }
}
