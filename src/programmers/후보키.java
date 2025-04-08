package programmers;

import java.util.*;

public class 후보키 {

    List<Set<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int columnCount = relation[0].length;

        for (int size = 1; size <= columnCount; size++) {
            dfs(0, size, new LinkedHashSet<>(), relation);
        }

        return candidateKeys.size();
    }

    private void dfs(int idx, int limit, Set<Integer> currSet, String[][] relation) {
        if (currSet.size() == limit) {
            if (isUnique(currSet, relation) && isMinimal(currSet)) {
                candidateKeys.add(new HashSet<>(currSet));
            }
            return;
        }

        for (int i = idx; i < relation[0].length; i++) {
            currSet.add(i);
            dfs(i + 1, limit, currSet, relation);
            currSet.remove(i);
        }
    }

    private boolean isUnique(Set<Integer> currSet, String[][] relation) {
        Set<String> seen = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int col : currSet) {
                sb.append(row[col]).append(",");
            }
            seen.add(sb.toString());
        }

        return seen.size() == relation.length;
    }

    private boolean isMinimal(Set<Integer> currSet) {
        for (Set<Integer> key : candidateKeys) {
            if (currSet.containsAll(key)) {
                return false; // 진부분집합 존재 => 최소성 X
            }
        }
        return true;
    }
}


/*
14:15 ~ 15:43(못품)

후보키: 유일성과 최소성을 가지는 속성의 집합
- 유일성: 모든 튜플에 대해서 유일하게 식별되어야 함
- 최소성: 유일성을 가지는 속성 집합 중에서 더 이상 속성을 제거할 수 없는 것


릴레이션에서 각 속성을 기준으로 유일성을 가지는지 확인


릴레이션에서 속성을 기준으로 dfs를 돌리고 그것을 기준으로 Set 중복 체크를 한다면?
-> 최소성을 보장할 수 없음


기준 - 1개
1. 현재 기준으로 유일성과 최소성을 보장하는 것을 만듬
2. 만족하지 못하는 것들을 대상으로 기준을 높여서 체크
3. 반복

 */
