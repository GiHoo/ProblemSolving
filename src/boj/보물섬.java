package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        System.out.println(maxDistance);
    }

    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0}); // {현재 x 좌표, 현재 y 좌표, 이동 거리}
        visited[x][y] = true;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDist = cur[2];

            maxDist = Math.max(maxDist, curDist);

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, curDist + 1});
                }
            }
        }

        return maxDist;
    }
}

