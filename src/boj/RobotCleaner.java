package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner {

    static int N, M;
    static int[][] rooms;
    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 0, 동 1, 남 2, 서 3

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        rooms = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = cleanRoom(x, y, direction);

        System.out.println(answer);
    }

    private static int cleanRoom(int x, int y, int direction) {
        int count = 0;

        while (true) {
            if (rooms[x][y] == 0) {
                rooms[x][y] = 2;
                count++;
            }

            boolean cleaned = false;
            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4; // 반시계 방향으로 회전
                int nx = x + moves[direction][0];
                int ny = y + moves[direction][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && rooms[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    cleaned = true;
                    break;
                }
            }

            if (!cleaned) { // 모든 방향이 청소 or 벽인 경우
                int backward = (direction + 2) % 4; // 후진
                x += moves[backward][0];
                y += moves[backward][1];

                if (x < 0 || x >= N || y < 0 || y >= M || rooms[x][y] == 1) {
                    break; // 후진 불가능 시 종료
                }
            }
        }

        return count;
    }
}
