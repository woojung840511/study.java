package algorithm.programmers.Level1;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 신고_결과_받기 {

    public static void main(String[] args) {
        int[] solution = new 신고_결과_받기().solution(
            new String[]{"muzi", "frodo", "apeach", "neo"},
            new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
            2
        );

        System.out.println(solution);
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        // Map <신고당한 사람, Set<신고한 사람들>> 만들기
        Map<String, Set<String>> reportMap = new HashMap<>();
        Arrays.stream(report).forEach(
            r -> {
                String[] rArray = r.split(" ");
                String reporter = rArray[0]; // 신고한 사람
                String reported = rArray[1]; // 신고당한 사람

                Set<String> distinctReporters = reportMap.getOrDefault(reported, new HashSet<>());
                distinctReporters.add(reporter);

                reportMap.put(reported, distinctReporters);
            }
        );

        int[] ints = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];

            long matachCount = reportMap.values().stream()
                .filter(reporters -> reporters.size() >= k) // K번 이상 신고당한 이용자를 신고한 사람들
                .flatMap(Collection::stream)
                .filter(reporter -> reporter.equals(id)) // id_list의 id와 매치하는 건수 => 해당 id에게 보내지는 메일의 수가 됨
                .count();

            ints[i] = (int) matachCount;
        }

        return ints;


    }
}

