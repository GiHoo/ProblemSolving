package programmers;

public class 스티커_모으기 {
    public int solution(int sticker[]) {
        int n = sticker.length;

        if (n == 1) {
            return sticker[0];
        }
        if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}

/*

연결 리스트에서 하나의 인덱스를 선택하면, 인접한 인덱스에는 접근 불가능


14, 6, 5, 11, 3, 9, 2, 10

5 11 3 9 2

14, 11, 9 34
14, 5, 3, 2 24
14, 5, 9 28

결국 첫 인덱스 고르냐 안고르냐에 따라 달라질 듯

 */
