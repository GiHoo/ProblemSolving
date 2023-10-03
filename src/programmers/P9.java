package programmers;

import java.util.*;

public class P9 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        List<String> list = new ArrayList<>();
        for(int i=0; i<strings.length; i++) {
            String target = (strings[i].charAt(n) + strings[i]);
            list.add(target);
        }

        Collections.sort(list);

        List<String> newList = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            String target = list.get(i).substring(1);
            newList.add(target);
        }

        for(int i=0; i<list.size(); i++) {
            answer[i] = newList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
