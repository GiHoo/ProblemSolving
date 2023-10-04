package programmers;

public class P10 {
    public int[] solution(String s) {
        int N = s.length();
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            if(i==0) answer[i] = -1;
            int target1 = s.charAt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i - 1; j++) {
                if(target1 == s.charAt(j)) min = Integer.min(min, i-j);
            }
            if(min == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = min;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s1 = "banana";
        String s2 = "foobar";

        P10 p = new P10();

        for (int i = 0; i < s1.length(); i++) {
            System.out.print(p.solution(s1)[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < s2.length(); i++) {
            System.out.print(p.solution(s2)[i] + " ");
        }
    }
}
