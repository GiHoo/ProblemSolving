package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumMeetingRoom {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Meeting> meetingList = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingList.add(new Meeting(start, end));
        }

        meetingList.sort(((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            else return o1.start - o2.start;
        }));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Meeting meeting : meetingList) {
            if (pq.isEmpty()) {
                pq.add(meeting.end);
            } else {
                if (pq.peek() <= meeting.start) {
                    pq.poll();
                    pq.add(meeting.end);
                } else {
                    pq.add(meeting.end);
                }
            }
        }

        System.out.print(pq.size());
    }

    static class Meeting {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }
}
