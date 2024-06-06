package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 포켓몬마스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int monsterCount = Integer.parseInt(st.nextToken());
        int missionCount = Integer.parseInt(st.nextToken());

        Map<Integer, String> monsters1 = new HashMap<>();
        Map<String, Integer> monsters2 = new HashMap<>();

        for (int i = 0; i < monsterCount; i++) {
            String monster = br.readLine();
            monsters1.put(i + 1, monster);
            monsters2.put(monster, i + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < missionCount; i++) {
            String mission = br.readLine();

            if (checkIsIndex(mission)) {
                int index = Integer.parseInt(mission);
                String target = monsters1.get(index);

                sb.append(target);
            } else {
                int target = monsters2.get(mission);

                sb.append(target);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean checkIsIndex(String mission) {
        try {
            int tmp = Integer.parseInt(mission);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
