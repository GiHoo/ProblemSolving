package programmers;

public class P7 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (Character.isUpperCase(ch)) {
                if (ch + n > 90) {
                    sb.append((char) (ch + n - 26));
                } else sb.append((char) (ch + n));
            } else if (Character.isLowerCase(ch)) {
                if (ch + n > 122) {
                    sb.append((char) (ch + n - 26));
                } else sb.append((char) (ch + n));
            } else sb.append(ch);
        }
        return sb.toString();
    }
    /*
    A~Z 65~90
    a~z 97~122
     */

    public static void main(String[] args) {
        System.out.println(new P7().solution("AB", 1));
        System.out.println(new P7().solution("a B z", 4));
        System.out.println(new P7().solution("z", 1));
    }
}
