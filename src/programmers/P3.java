package programmers;

public class P3 {
    public String solution(String s) {
        String[] arr = s.split("");
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        for (int i=0; i<arr.length; i++) {
            if(arr[i].equals(" ")) {
                stringBuilder.append(arr[i]);
                cnt = 0;
            }
            else {
                if(cnt%2==0) stringBuilder.append(arr[i].toUpperCase());
                else stringBuilder.append(arr[i].toLowerCase());
                cnt++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P3().solution("AA aa ZZ zz"));
    }
}

/*

각 단어의 짝수번째 알파벳은 대문자, 홀수번째 알파벳은 소문자

공백 기준으로 문장을 단어로 나눈다.


 */
