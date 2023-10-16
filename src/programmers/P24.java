package programmers;

public class P24 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int best = 0;
        int worst = 0;

        int min = 0;
        int max = 0;

        int cnt = 0;
        for (int lotto : lottos) {
            if(lotto == 0) continue;
            for (int i = 0; i < win_nums.length; i++) {
                if(win_nums[i] == lotto) cnt++;
            }
        } // 현재 가지고 있는 당첨의 수
        min = cnt;

        for (int lotto : lottos) {
            if(lotto != 0) continue;
            cnt++;
        } // 0을 가지고 만들기
        max = cnt;

        worst = getGrade(min);
        best = getGrade(max);

        return new int[]{best, worst};
    }

    private int getGrade(int number) {
        int grade = 0;
        switch (number) {
            case 6 : grade = 1; break;
            case 5 : grade = 2; break;
            case 4 : grade = 3; break;
            case 3 : grade = 4; break;
            case 2 : grade = 5; break;
            default: grade = 6;
        }
        return grade;
    }

    public static void main(String[] args) {
        System.out.println(new P24().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})[0]);
        System.out.println(new P24().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})[1]);
    }
}
