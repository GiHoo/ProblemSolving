package programmers;

public class P8 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String tmp = Integer.toBinaryString(arr1[i] | arr2[i]); //비트 연산자
            tmp = tmp.replace('0', ' ');
            tmp = tmp.replace('1', '#');

            while (tmp.length() < n) {
                tmp = ' ' + tmp;
            }

            answer[i] = tmp;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        P8 p8 = new P8();
        for (int i = 0; i < n; i++) {
            System.out.println(p8.solution(n, arr1, arr2)[i]);
        }
    }
}
