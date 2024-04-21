package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RobotCleaner {

    static int N, M;
    static int[][] rooms;
    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        rooms = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        queue.add(new Node(startX, startY, startD));

        int answer = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int direction = node.direction;

            if (rooms[x][y] == 0) {
                rooms[x][y] = 2;
                System.out.println(answer + ". 현재 좌표 " + x + " " + y + " 방향 " + direction);
                answer++;
                if (checkIsOkToClean(x, y)) {
                    while (true) {
                        int[] newPoint = changePoint(x, y, direction);
                        int nx = newPoint[0];
                        int ny = newPoint[1];
                        if (nx >= 0 && ny >= 0 && nx < rooms.length && ny < rooms[0].length
                                && rooms[nx][ny] == 0) {
                            queue.add(new Node(nx, ny, direction));
                            break;
                        } else {
                            direction = changeDirection(direction);
                        }
                    }
                } else {
                    if (!canMoveToBack(x, y, direction)) break;
                }
            }
        }

        System.out.print(answer);
    }

    private static boolean canMoveToBack(int x, int y, int direction) {
        int nx = x + moves[direction][0];
        int ny = y + moves[direction][1];

        if (nx >= 0 && ny >= 0 && nx < rooms.length && ny < rooms[0].length && rooms[nx][ny] != 1) {
            queue.add(new Node(nx, ny, direction));
            return true;
        }

        return false;
    }

    private static int[] changePoint(int x, int y, int direction) {
        return new int[]{x + moves[direction][0], y + moves[direction][1]};
    }

    private static int changeDirection(int direction) {
        return (direction + 3) % 4;
    }

    private static boolean checkIsOkToClean(int x, int y) {
        boolean toClean = false;

        for (int i = 0; i < moves.length; i++) {
            int nx = x + moves[i][0];
            int ny = y + moves[i][1];

            if (nx >= 0 && ny >= 0 && nx < rooms.length && ny < rooms[0].length
                    && rooms[nx][ny] == 0) {
                toClean = true;
                break;
            }
        }

        return toClean;
    }

    static class Node {

        int x;
        int y;
        int direction;

        public Node(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}
