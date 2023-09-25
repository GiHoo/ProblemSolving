package programmers;

import java.util.*;

public class P1 {

    public long solution(long n) {
        long answer = 0;

        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Collections.reverseOrder());

        String tmp = "";

        for(String s : str) tmp += s;

        answer = Long.parseLong(tmp);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P1().solution(118372));
    }
}
