package programmers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 요세푸스_문제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        while (deque.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                int num = deque.pollFirst();
                deque.addLast(num);
            }

            deque.pollFirst();
        }

        System.out.print(deque.poll());
    }
}
