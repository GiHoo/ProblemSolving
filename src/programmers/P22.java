package programmers;

public class P22 {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        int[] knights = new int[number+1];

        for(int i=1; i<=number; i++){
            for(int j=i; j<=number; j+=i) {
                knights[j] += 1;
            }
        }

        for (int i = 1; i <= number; i++) {
            if(knights[i] <= limit) answer += knights[i];
            else answer += power;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new P22().solution(5, 3, 2));
    }
}
