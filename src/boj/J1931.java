package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class J1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<TimeTable> tables = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tables.add(new TimeTable(start, end));
        }

        tables.sort((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }
        });

        int cnt = 0;
        int now_end = 0;

        for (int i = 0; i < tables.size(); i++) {
            if (i == 0) {
                now_end = tables.get(i).end;
                cnt++;
            } else {
                int start = tables.get(i).start;
                int end = tables.get(i).end;

                if (start >= now_end) {
                    now_end = end;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static class TimeTable {

        int start;
        int end;

        public TimeTable(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/*

1931 회의실 배정

정렬
끝나는 시간 기준 정렬
끝나는 시간이 같다면 시작 시간을 기준으로

 */
