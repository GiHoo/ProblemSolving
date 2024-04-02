package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordMath {

    static int[] nums = new int[26]; // A B C D E F G H I J 점수

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }

        for (int i = 0; i < inputs.length; i++) {
            String target = inputs[i];

            for (int j = 0; j < target.length(); j++) {
                int index = target.charAt(j) - 'A';

                nums[index] += Math.pow(10, target.length() - j - 1); // 해당 숫자의 자리수 정렬
            }
        }

        Arrays.sort(nums); // 크기 순으로 정렬

        int weight = 9;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) continue;
            answer += nums[i] * weight;
            weight--;
        }

        System.out.println(answer);
    }
}
