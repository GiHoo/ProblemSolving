package programmers;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P12 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int index = 0;

        for(int x : set) {
            answer[index++] = x;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        P12 p12 = new P12();
        int[] numbers = {2, 1, 3, 4, 1};
    }
}
