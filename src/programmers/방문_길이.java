package programmers;

import java.util.HashMap;
import java.util.Map;

public class 방문_길이 {

    static int[][] matrix = new int[11][11];

    public int solution(String dirs) {
        Map<String, Integer> map = new HashMap<>();

        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            char direction = dirs.charAt(i);

            int nx, ny;
            if (direction == 'L') {
                nx = x;
                ny = y - 1;
            } else if (direction == 'R') {
                nx = x;
                ny = y + 1;
            } else if (direction == 'U') {
                nx = x + 1;
                ny = y;
            } else {
                nx = x - 1;
                ny = y;
            }

            if (!checkValidation(nx, ny)) continue;

            map.put(x + " " + y + " to " + nx + " " + ny,
                    map.getOrDefault(x + " " + y + " to " + nx + " " + ny, 0) + 1);
            map.put(nx + " " + ny + " to " + x + " " + y,
                    map.getOrDefault(nx + " " + ny + " to " + x + " " + y, 0) + 1);

            x = nx;
            y = ny;
        }

        return map.size() / 2;
    }

    static boolean checkValidation(int x, int y) {
        return (x >= 0 && y >= 0 && x < 11 && y < 11);
    }
}
