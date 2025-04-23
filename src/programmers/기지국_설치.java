package programmers;

public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int boundary = 2 * w + 1;

        int prev = 1;
        for (int station : stations) {
            int before = station - w;
            int after = station + w;

            if (before > prev) {
                int tmp = before - prev;

                int div = tmp / boundary;
                int off = tmp % boundary;

                int cnt = div + (off != 0 ? 1 : 0);
                answer += cnt;
            }

            prev = after + 1;
        }

        if (prev <= n) {
            int tmp = n - prev + 1;

            int div = tmp / boundary;
            int off = tmp % boundary;

            int cnt = div + (off != 0 ? 1 : 0);
            answer += cnt;
        }

        return answer;
    }
}

/*
기지국 설치
15:40 ~

초기에 기지국에 설치되어 있음
기지국 범위를 통해 최소 개수로 채우기

N: 200,000,000 일단 무조건 dp OR greedy

stations로 기지국 위치 확인 후 그 이전 범위 체크

station - 9, W - 2
=> 7 ~ 11 작동
=> 1 ~ 6, 12 ~ 16 확인
=> 하나의 기지국 설치 시 작동하는 구간 - 1 + 2 * 2 = 5
1 ~ 6 => 2, 12 ~ 16 => 1

1. stations에서 설치된 위치 확인
2. 설치된 구간에서 W +- 하여 위치 확인
3. 1부터 시작하여 그 구간에 작동하는지 확인 후 넘기기


*/
