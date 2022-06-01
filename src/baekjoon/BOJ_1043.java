package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int truthCount = 0, personCount, person;
        int[] truthPersonArr;
        if (st.countTokens() != 1) {
            truthCount = Integer.parseInt(st.nextToken());
            truthPersonArr = new int[truthCount];
            for (int i = 0; i < truthCount; i++) {
                truthPersonArr[i] = Integer.parseInt(st.nextToken());
            }
        } else {
            System.out.println(m);
            return;
        }

        Map<Integer, ArrayList<Integer>> personAndPartyMap = new HashMap<>();
        Map<Integer, ArrayList<Integer>> partyAndPersonMap = new HashMap<>();
        ArrayList<Integer> personList;
        for (int i = 1; i <= m; i++) { //party num
            st = new StringTokenizer(br.readLine());
            personCount = Integer.parseInt(st.nextToken());
            personList = new ArrayList<>();
            for (int j = 1; j <= personCount; j++) {
                person = Integer.parseInt(st.nextToken());
                personList.add(person);
                if (!personAndPartyMap.containsKey(person)) personAndPartyMap.put(person, new ArrayList<>());
                personAndPartyMap.get(person).add(i);
            }
            partyAndPersonMap.put(i, personList);
        }

        Queue<Integer> queue = new LinkedList<>();

        int count = m;

        boolean[] knowTruthPerson = new boolean[n + 1];
        boolean[] isTrueParty = new boolean[m + 1];

        for (int i = 0; i < truthCount; i++) { // 모든 진실파티 찾기
            queue.add(truthPersonArr[i]);
            while (!queue.isEmpty()) {
                person = queue.poll();
                if (!knowTruthPerson[person]) {
                    knowTruthPerson[person] = true;
                    if(personAndPartyMap.containsKey(person))
                        for (int party : personAndPartyMap.get(person)) { //해당 사람이 속한 파티 제외
                            if (!isTrueParty[party]) {
                                isTrueParty[party] = true;
                                count--;
                                queue.addAll(partyAndPersonMap.get(party));//그 파티에 참석한 사람 queue에 추가}
                            }
                        }
                }
            }
        }
        System.out.println(count);
    }
}
