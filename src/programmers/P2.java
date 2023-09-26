package programmers;

import java.util.*;

public class P2 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        for(int i=0; i<str.length; i++) sb.append(str[i]);

        return sb.toString();
    }
}
