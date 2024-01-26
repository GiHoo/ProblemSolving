package leetcode;

public class TwoSum {
    public int twoSum(int[] arr, int target) {
        int answer = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int num1 = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                int num2 = arr[j];
                if (target == (num1 + num2)) answer++;
            }
        }
        return answer;
    }
}
