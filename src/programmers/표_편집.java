package programmers;

import boj.Main;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 표_편집 {

    private static List<Integer> memberList = new ArrayList<>();
    private static int currentMember;
    private static Deque<Integer> restoreDeque = new ArrayDeque<>();
    private static int currentRow;

    private static void init(int n, int k) {
        for (int i = 0; i < n; i++) {
            memberList.add(i);
        }

        currentMember = n;
        currentRow = k;
    }

    private static void U(int row) {
        int newRow = currentRow - row;
        while (newRow < 0) {
            newRow += currentMember;
        }

        currentRow = newRow;
    }

    private static void D(int row) {
        int newRow = currentRow + row;
        while (newRow >= currentMember) {
            newRow -= currentMember;
        }

        currentRow = newRow;
    }

    private static void C() {
        if (currentRow == currentMember - 1) {
            // 행이 마지막인 경우 윗 행 삭제
            Integer removeTarget = memberList.remove(currentRow);
            restoreDeque.add(removeTarget);

            currentRow--;
        } else {
            // 아니라면 바로 아래 선택
            Integer removeTarget = memberList.remove(currentRow);
            restoreDeque.add(removeTarget);

//            currentRow++;
        }

        currentMember--;
    }

    private static void Z() {
        int restoreTarget = restoreDeque.pollLast();
        memberList.add(restoreTarget, restoreTarget);

        currentMember++;
    }

    public String solution(int n, int k, String[] cmd) {
        init(n, k);
        for (int i = 0; i < cmd.length; i++) {
            String command = cmd[i];

            if (command.charAt(0) == 'U') {
                int row = Integer.parseInt(command.split(" ")[1]);
                U(row);
            } else if (command.charAt(0) == 'D') {
                int row = Integer.parseInt(command.split(" ")[1]);
                D(row);
            } else if (command.charAt(0) == 'C') {
                C();
            } else {
                Z();
            }

            for (int j = 0; j < memberList.size(); j++) {
                System.out.print(memberList.get(j) + " ");
            }
            System.out.println();
        }

        return "";
    }

    public static void main(String[] args) {
        표_편집 p = new 표_편집();
        p.solution(8, 2,
                new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"});
    }
}
