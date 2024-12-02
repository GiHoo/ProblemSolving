package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {

    public static void main(String[] args) {
        베스트앨범 p = new 베스트앨범();
        System.out.println(
                p.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500})
        );
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Song>> map = new HashMap<>();
        Map<String, Integer> genreCntMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }

            map.get(genres[i]).add(new Song(plays[i], i));
            genreCntMap.put(genres[i], genreCntMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 내림차순 정렬
        List<String> genreCntList = new ArrayList<>(genreCntMap.keySet());
        genreCntList.sort((o1, o2) -> genreCntMap.get(o2) - genreCntMap.get(o1));

        List<Integer> answer = new ArrayList<>();
        for (String genre : genreCntList) {
            List<Song> songs = map.get(genre);

            // 재생 수 기준으로 내림차순 정렬, 재생 수가 같다면 고유 번호 오름차순
            songs.sort((o1, o2) -> {
                if (o1.plays == o2.plays) return o1.number - o2.number;
                else return o2.plays - o1.plays;
            });

            answer.add(songs.get(0).number);
            if (songs.size() >= 2) {
                answer.add(songs.get(1).number);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Song {

        int plays;
        int number;

        public Song(int plays, int number) {
            this.plays = plays;
            this.number = number;
        }
    }
}
