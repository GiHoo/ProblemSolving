package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lectureCount = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[lectureCount];

        StringTokenizer st;
        for (int i = 0; i < lectureCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start_time = Integer.parseInt(st.nextToken());
            int end_time = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(start_time, end_time);
        }

        Arrays.sort(lectures, (o1, o2) -> {
            if (o1.start_time == o2.start_time) return o1.end_time - o2.end_time;
            else return o1.start_time - o2.start_time;
        });

        Queue<Integer> pq = new PriorityQueue<>();

        pq.add(lectures[0].end_time);

        for (int i = 1; i < lectureCount; i++) {
            Lecture lecture = lectures[i];
            int start_time = lecture.start_time;
            int end_time = lecture.end_time;

            if (pq.peek() <= start_time) {
                pq.poll();
            }
            pq.add(end_time);
        }


        System.out.println(pq.size());
    }

    static class Lecture {
        int start_time;
        int end_time;

        public Lecture(int start_time, int end_time) {
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }
}



/**
 * 문제 링크: https://www.acmicpc.net/problem/11000
 * 메모리: 15636 KB
 * 시간: 180 ms
 * 시간 복잡도: O(N^3)
 * 공간 복잡도: O(N^2)
 * <p>
 * 풀이
 * 입력으로 요일이 5(금요일)가 들어온다면 추가하지 않는다.
 * 들어온 수업을 차례대로 반복문을 통해 DFS를 진행한다.
 * DFS 전, 후로 chageTable, restoreTable 메서드를 통해 시간표를 수정한다.
 * DFS 인자로 index가 들어감.
 * 문제를 봤을 때 처음으로 들어가는 수업에 따라 경우가 다르게 됨
 * 그렇기에 이전에 table에 추가했던 수업 다음부터 DFS를 돌려 문제를 풀이
 * DFS 내부에서는 수업이 시간표에 있는지 확인하는 isPossible 수행
 */
