package programmers;

import java.util.ArrayList;
import java.util.List;

public class P19 {
    private static final int[] su1 = {1, 2, 3, 4, 5};
    private static final int[] su2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] su3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if(answer == su1[i%5])  p1++;
            if(answer == su2[i%8])  p2++;
            if(answer == su3[i%10]) p3++;
        }
        int max = 0;
        max = Integer.max(max, p1);
        max = Integer.max(max, p2);
        max = Integer.max(max, p3);

        List<Integer> list = new ArrayList<>();
        if(max == p1) list.add(1);
        if(max == p2) list.add(2);
        if(max == p3) list.add(3);

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(new P19().solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new P19().solution(new int[]{1, 3, 2, 4, 2}));
    }
}

/*

1번 수포자 -> 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 ... -> 5번 마다 반복
2번 수포자 -> 2, 1, 2, 3, 2, 4, 2, 5, 2, 1 ... -> 8번 마다 반복
3번 수포자 -> 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 ... -> 10번 마다 반복



 */
