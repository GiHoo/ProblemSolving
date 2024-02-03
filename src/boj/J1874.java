package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class J1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 0;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(N -- > 0) {

            int value = Integer.parseInt(br.readLine());

            if(value > start) {
                for(int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            }

            else if(stack.peek() != value) {
                System.out.println("NO");
                return;		// 또는 System.exit(0); 으로 대체해도 됨.
            }

            stack.pop();
            sb.append('-').append('\n');

        }

        System.out.println(sb);

    }
}

/*


4
3
6
8
7
5
2
1

4
4 3
4 3 6
4 3 6 8



 */
