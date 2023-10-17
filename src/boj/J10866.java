package boj;

import java.util.*;
import java.io.*;

public class J10866 {

    private static final List<Integer> list = new LinkedList<>();

    private static void pushFront(int number) {
        list.add(0, number);
    }

    private static void pushBack(int number) {
        list.add(list.size(), number);
    }

    private static void popFront() {
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(0));
            list.remove(0);
        }
    }

    private static void popBack() {
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(list.size() -1));
            list.remove(list.size() - 1);
        }
    }

    private static void size() {
        System.out.println(list.size());
    }

    private static void isEmpty() {
        if(list.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void front() {
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(0));
        }
    }

    private static void back() {
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(list.size() -1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("push_front")) {
                int number = Integer.parseInt(st.nextToken());
                pushFront(number);
            } else if (command.equals("push_back")) {
                int number = Integer.parseInt(st.nextToken());
                pushBack(number);
            } else if(command.equals("pop_front")) {
                popFront();
            } else if(command.equals("pop_back")) {
                popBack();
            } else if(command.equals("size")) {
                size();
            } else if(command.equals("empty")) {
                isEmpty();
            } else if(command.equals("front")) {
                front();
            } else if(command.equals("back")) {
                back();
            } else {
                System.out.println("잘못된 입력");
            }

        }
    }
}
