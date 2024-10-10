package programmers;

import java.util.*;

class 크레인_인형_뽑기 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Deque<Integer>> dequeList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            dequeList.add(new ArrayDeque<>()); // board 칸 수 만큼 deque 추가
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != 0) {
                    dequeList.get(i).addLast(board[j][i]);
                }
            }
        } // deque 추가

        Deque<Integer> answerDeque = new ArrayDeque<>();
        for (int i = 0; i < moves.length; i++) {
            Deque<Integer> deque = dequeList.get(moves[i] - 1);

            if (!deque.isEmpty()) {
                int target = deque.pop();

                if (!answerDeque.isEmpty() && answerDeque.peekLast() == target) {
                    answerDeque.pollLast();
                    answer += 2;

                    continue;
                }

                answerDeque.addLast(target);
            }
        }

        return answer;
    }
}
