package leetcode;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        // banned 값을 set에 보관(어차피 하나일 것이니)
        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        // \W+ -> 문자 단어가 아닌 것(쉼표, 연속 띄어 쓰기, 마침표 등등)을 " " 공백로 치환
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        // 밴 되지 않은 단어의 출현 개수를 map에 저장
        Map<String, Integer> countWord = new HashMap<>();
        for (String word : words) {
            if(!ban.contains(word)) countWord.put(word, countWord.getOrDefault(word, 0) + 1);
        }

        int max = 0;
        for (String str : countWord.keySet()) {
            max = Integer.max(max, countWord.get(str));
        }

        String answer = "";
        for (String str : countWord.keySet()) {
            if (countWord.get(str) == max) answer = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        String paragraph = paragraph = "Bob. hIt, baLl";
        String[] banned =  {"bob", "hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));
    }
}
