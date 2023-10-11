package programmers;

public class P20 {
    public int solution(int n) {
        int answer = 0;
        int[] nums = new int[n+1];

        for(int i=2; i<=n; i++) nums[i] = i; // 자기 숫자로 초기화

        for (int i = 2; i <= n; i++) {
            if(nums[i] == 0) continue;
            for (int j = i * 2; j <= n; j += i) {
                nums[j] = 0;
            }
        }

        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != 0) answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new P20().solution(10));
        System.out.println(new P20().solution(5));
    }
}
