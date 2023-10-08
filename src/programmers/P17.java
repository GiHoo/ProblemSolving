package programmers;

public class P17 {
    public int solution(int[] nums) {
        int[] counts = new int[200001];
        int answer = 0;
        for (int num : nums) {
            if (counts[num] == 0) {
                answer++;
            }
            counts[num]++;
        }
        if(answer > nums.length / 2) {
            answer = nums.length / 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P17().solution(new int[]{3, 3, 3, 2, 2, 4}));
    }
}


