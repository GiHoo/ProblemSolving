package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("Enter", "님이 들어왔습니다.");
        systemMessage.put("Leave", "님이 나갔습니다.");

        Map<String, String> userInfos = new HashMap<>();
        for (String log : record) {
            String[] logs = log.split(" ");

            if (logs.length == 3) {
                userInfos.put(logs[1], logs[2]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String log : record) {
            String[] logs = log.split(" ");

            if (systemMessage.containsKey(logs[0])) {
                answer.add(userInfos.get(logs[1]) + systemMessage.get(logs[0]));
            }
        }

        return answer.stream().toArray(String[]::new);
    }
}

/**
 NlogN

 닉네임 변경 -> 기존 채팅방에 출력된 닉네임도 변경 / 중복 닉네임 허용
 - 채팅방을 나간 후, 새로운 닉네임으로 입장
 - 채팅방에서 닉네임 변경

 Map에다가 String, String => uid, 닉네임
 이미 uid 존재하면 닉네임 변경으로

 Enter 기존 uid 새로운 닉네임
 Change 기존 uid 새로운 닉네임

 */
