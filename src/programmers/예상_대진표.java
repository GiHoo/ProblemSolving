package programmers;

public class 예상_대진표 {

    public int solution(int n, int a, int b) {
        int answer = 0;
        int na = a - 1;
        int nb = b - 1;

        while (true) {
            if (na == nb) break;
            else {
                na /= 2;
                nb /= 2;
                answer++;
            }
        }

        return answer;
    }
}
