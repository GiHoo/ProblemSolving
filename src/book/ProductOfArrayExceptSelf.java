package book;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int tmp = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 3, 5 ,7}));
    }
}

/*

배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 엘리먼트의 곱셈결과가 되도록 출력하라.
입력 - [ 1, 3 , 5 , 7]
출력 - [105, 35, 21, 15]
주의 나눗셈을 하지 않고 O(n)에 풀이하라.


1 3 5 7

1 1 3 15




 */
