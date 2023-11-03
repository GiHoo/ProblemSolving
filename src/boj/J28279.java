package boj;

import java.util.*;
import java.io.*;

public class J28279 {
    private static final List<Integer> deque = new LinkedList<>();

    public static void addFirst(int value) {
        deque.add(0, value);
    }

    public static void addLast(int value) {
        deque.add(deque.size(), value);
    }

    public static int pollFirst() {
        if(isEmpty() == 1) return -1;
        else {
            int value = deque.get(0);
            deque.remove(0);
            return value;
        }
    }

    public static int pollLast() {
        if(isEmpty() == 1) return -1;
        else {
            int value = deque.get(deque.size() - 1);
            deque.remove(deque.size() - 1);
            return value;
        }
    }

    public static int getSize() {
        return deque.size();
    }

    public static int isEmpty() {
        if(deque.isEmpty()) return 1;
        else return 0;
    }

    public static int peekFirst() {
        if(isEmpty() == 1) return -1;
        else return deque.get(0);
    }

    public static int peekLast() {
        if(isEmpty() == 1) return -1;
        else return deque.get(deque.size() - 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int value = Integer.parseInt(st.nextToken());
                addFirst(value);
            } else if (command == 2) {
                int value = Integer.parseInt(st.nextToken());
                addLast(value);
            }
            else if (command == 3) sb.append(pollFirst()).append("\n");
            else if (command == 4) sb.append(pollLast()).append("\n");
            else if (command == 5) sb.append(getSize()).append("\n");
            else if (command == 6) sb.append(isEmpty()).append("\n");
            else if (command == 7) sb.append(peekFirst()).append("\n");
            else if (command == 8) sb.append(peekLast()).append("\n");
        }
        System.out.println(sb);
    }
}
