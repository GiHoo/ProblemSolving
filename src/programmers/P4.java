package programmers;

public class P4 {
    public int solution(String t, String p) {
        int answer = 0;
        int tlen = t.length();
        int plen = p.length();
        long pint = Long.parseLong(p);
        for (int i = 0; i <= tlen - plen; i++) {
            long target = Long.parseLong(t.substring(i, i + plen));
            if(target <= pint) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P4().solution("500220839878", "7"));
    }
}

