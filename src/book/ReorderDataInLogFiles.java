package book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {

        //문자를 담을 리스트
        List<String> letterList = new ArrayList<>();
        //숫자를 담을 리스트
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            //log의 두번째 단어(첫 단어는 식별자)의 첫 문자를 확인
            if (Character.isLetter(log.split(" ")[1].charAt(0))) {
                letterList.add(log);
            } else {
                digitList.add(log);
            }
        }

        Collections.sort(letterList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ", 2);
                String[] s2 = o2.split(" ", 2);

                int compare = s1[1].compareTo(s2[1]);

                if (compare == 0) {
                    return s1[0].compareTo(s2[0]);
                } else return compare;
            }
        });

        letterList.sort((o1, o2) -> {
            String[] s1 = o1.split(" ", 2);
            String[] s2 = o2.split(" ", 2);
            int compare = s1[1].compareTo(s2[1]);
            if (compare == 0) {
                return s1[0].compareTo(s2[0]);
            } else return compare;
        });


        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }
}
