package programmers;

public class P5 {
    public int solution(int[] number) {
        int answer = 0;
        int n = number.length;
        for (int i = 0; i < n - 2; i++) {
            int num1 = number[i];
            for (int j = i+1; j < n-1; j++) {
                int num2 = number[j];
                for (int k = j+1; k < n; k++) {
                    int num3 = number[k];
                    if(num1 + num2 + num3 == 0) answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P5().solution(new int[]{-2, 3, 0, 2, -5}));
    }
}
