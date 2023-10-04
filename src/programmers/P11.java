package programmers;

public class P11 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            int cnt = food[i]/2;
            for(int j=1; j<=cnt; j++) {
                sb.append(i);
            }
        }
        String left = sb.toString();
        sb.reverse();
        String right = sb.toString();
        String answer = left + "0" + right;
        return answer;
    }

    public static void main(String[] args) {
        P11 p11 = new P11();
        System.out.println(p11.solution(new int[]{1, 3, 4, 6}));
    }
}
