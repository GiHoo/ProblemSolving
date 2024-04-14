package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단_거리 {

    static int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 0)); // 시작 지점 삽입
        maps[0][0] = 0;

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            int currX = tmp.x;
            int currY = tmp.y;
            int currCnt = tmp.cnt;

            if (currX == maps.length - 1 && currY == maps[0].length - 1) {
                answer = Integer.min(answer, currCnt + 1);
            } else {
                for (int[] direction : directions) {
                    int nx = currX + direction[0];
                    int ny = currY + direction[1];

                    if (nx >= 0 && ny >= 0 && nx < maps.length && ny < maps[0].length
                            && maps[nx][ny] == 1) {
                        queue.add(new Node(nx, ny, currCnt + 1));
                        maps[nx][ny] = 0;
                    }
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
