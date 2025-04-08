package programmers;

public class 문자열_압축 {
    public int solution(String s) {
        int minLength = s.length();

        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int compressedLength = getCompressedLength(s, unit);
            minLength = Math.min(minLength, compressedLength);
        }

        return minLength;
    }

    private int getCompressedLength(String s, int unit) {
        StringBuilder sb = new StringBuilder();
        String prev = s.substring(0, unit);
        int count = 1;

        for (int i = unit; i < s.length(); i += unit) {
            int end = Math.min(i + unit, s.length());
            String curr = s.substring(i, end);

            if (prev.equals(curr)) {
                count++;
            } else {
                sb.append(count > 1 ? count + prev : prev);
                prev = curr;
                count = 1;
            }
        }

        sb.append(count > 1 ? count + prev : prev);
        return sb.length();
    }
}
