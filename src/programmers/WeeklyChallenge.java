package programmers;
//https://programmers.co.kr/learn/courses/30/lessons/86971
//전력망을 둘로 나누기 lv2
//풀이 : https://velog.io/@ujone/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%84%EB%A0%A5%EB%A7%9D%EC%9D%84-%EB%91%98%EB%A1%9C-%EB%82%98%EB%88%84%EA%B8%B0-JAVA-qwc4ox2b

import java.util.ArrayList;
import java.util.List;

class Solution_86971 {
    public int solution(int n, int[][] wires) {
        int ret = Integer.MAX_VALUE;
        List<List<Integer>> map = new ArrayList<>(); //트리 맵 만들기
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<Integer>());
        }
        for (int[] wire : wires) { //인덱스를 노드 숫자라고 하고, 해당 노드에 연결관계인 노드들 저장
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        for (int[] wire : wires) { //각 링크를 끊어서 dfs 돌리기
            int curRet = dfs(map, wire[0], wire[0], wire[1], new boolean[n + 1]);
            ret = Math.min(Math.abs(n - curRet - curRet), ret); //(n-ret) - ret (탐색한 가중치 + n-탐색한 가중치  ==n)
        }

        return ret;
    }
    //s가 탐색 시작노드, l1,l2가 끊긴 링크
    //두개의 이진트리중 하나만 탐색한다. 다른 트리는 n-ret 으로 가중치를 구할 수 있다.
    int dfs(List<List<Integer>> map, int s, int l1, int l2, boolean [] visit ){
        if(visit[s]) return 0;
        visit[s] = true;
        int ret = 1; //가중치
        List<Integer> list = map.get(s); //시작 노드와 연결된 모든 노드목록 가져오기

        for (int i : list) {
            if((s==l1 && i==l2) ) continue; //탐색중인 노드가 끊긴 링크일경우 패스
            ret += dfs(map, i, l1, l2, visit);
        }
        return ret;
    }

}