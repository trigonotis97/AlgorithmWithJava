package programmers;
//https://programmers.co.kr/learn/courses/30/lessons/86971
//전력망을 둘로 나누기 lv2
//풀이 : https://velog.io/@ujone/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%84%EB%A0%A5%EB%A7%9D%EC%9D%84-%EB%91%98%EB%A1%9C-%EB%82%98%EB%88%84%EA%B8%B0-JAVA-qwc4ox2b

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

//https://programmers.co.kr/learn/courses/30/lessons/87694
//아이템 줍기
//풀이 : https://taehoung0102.tistory.com/95

class Solution_87694 {
    public static void main(String[] args) {
        int [] [] array ={{1,1,5,7}};
        System.out.println(Solution_87694.solution(array,1,1,4,7));
    }
//[[1,1,5,7]]	1	1	4 	7	9
    public  static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int start_x=characterX*2;
        int start_y=characterY*2;
        int end_x=itemX*2;
        int end_y=itemY*2;

        boolean[][] map= new boolean[103][103];
        int ted=0;

        for(int[] data:rectangle){
            //1.테두리 포함해서 직사각형 모두 true채우기
            for(int i=data[1]*2;i<=data[3]*2;i++){ //y위치
                for(int j=data[0]*2;j<=data[2]*2;j++){ //x위치
                    map[i][j]=true;

                }
            }
        }

        for(int[] data:rectangle){
            //2.테두리 제외해서 직사각형 내부 모두 false채우기
            for(int i=data[1]*2+1;i<data[3]*2;i++){ //원래 위치에서 1만큼 안쪽으로 선택.
                for(int j=data[0]*2+1;j<data[2]*2;j++){
                    map[i][j]=false;
                }
            }
        }

        //bfs 탐색
        Stack<Player> stack = new Stack<>();

        // 시작점 설정
        Player p = new Player(start_x,start_y);
        stack.add(p);

        List<Integer> result =new ArrayList<>();
        int cnt=0;

        //bfs 탐색 (한바퀴 돌때까지 반복)
        while(true){
            if(stack.isEmpty()){
                result.add(cnt);
                break;
            }
            Player temp=stack.pop();
            int x=temp.x;
            int y=temp.y;

            //도착하면 갯수 저장
            if(x==end_x&&y==end_y){
                result.add(cnt);
            }

            //지났으면 지난자리 false
            map[y][x]=false;

            //상하좌우에 true 있을경우 스택에 넣음
            if(map[y + 1][x]) stack.add(new Player(x,y+1));
            if(map[y][x + 1]) stack.add(new Player(x+1,y));
            if(map[y - 1][x]) stack.add(new Player(x,y-1));
            if(map[y][x - 1]) stack.add(new Player(x-1,y));

            cnt++;

        }
        //resutl(0)에 타겟까지의 거리 / result(1) 에 둘레 길이
        answer=Math.min(result.get(0)/2,result.get(1)/2-result.get(0)/2);
        return answer;
    }

    static class Player{
        int x;
        int y;

        public Player(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

}



class Solution_82612 {
    public long solution(int price, int money, int count) {
        long answer =money;

        for (; count > 0; count--) {
            answer -= price * count;
        }
        if(answer>0)
            return 0;
        return -answer;
    }

}
////모음사전
//class  Solution_84512 {
//    char[] aeiou = {'A','E','I','O','U'};
//    int count = 0;
//    boolean isStop = false;
//
//    public static int solution(String word) {
//        dfs(0, "", word);
//        return count;

//
//    public static void dfs(int depth, String next, String target) {
//        if (depth == 6) return;
//
//        if (next.equals(target)) {// 찾으려는 숫자가 맞을경우
//            isStop = true;
//            return;
//        }
//
//        for (int i = 0; i < 5; i++) { //직접 카운트하기
//            if (isStop) return;
//
//            if (depth + 1 < 6) count++; //단어 길이가 5보다 작을경우
//            dfs(depth + 1, next + aeiou[i], target);
//
//        }
//    }
//
//
//}