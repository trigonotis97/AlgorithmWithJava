package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int p=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());


        //입력받기
        Graph [] graph=new Graph[p+1]; //1부터 시작
        String [] tmpStr=new String[2];
        int [] pivots =new int[2];
        for (int i = 0; i < p + 1; i++) {
            graph[i]=new Graph();
        }
        for (int i = 0; i <n ; i++) {
            tmpStr=br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                pivots[j]=Integer.parseInt(tmpStr[j]);
            }
            graph[pivots[0]].nodes.add(pivots[1]);
            graph[pivots[1]].nodes.add(pivots[0]);

        }
        //정렬
        for (int i = 1; i <p+1; i++) {
            Collections.sort(graph[i].nodes);
        }

        //연산
        dfs(graph,start);
        System.out.println();
        for (int i = 1; i <p+1; i++) {
            graph[i].clear();
        }
        bfs(graph,start);



    }


    static void dfs(Graph[] graph,int curInd){
        System.out.print(curInd+ " ");
        graph[curInd].visit=true;
        for (int node: graph[curInd].nodes) {
            if(!graph[node].visit) dfs(graph,node);
        }
    }


    static void bfs(Graph[] graph,int curInd){

        Queue<Integer> queue =new LinkedList<>();
        queue.add(curInd);

        while (!queue.isEmpty()){
            int next=queue.poll();
            graph[next].visit=true;
            System.out.print(next+" ");
            for(int node: graph[next].nodes){
                if(!graph[node].visit){
                    queue.add(node);
                    graph[node].visit=true;
                }

            }
        }
    }



    static class Graph{
        public ArrayList<Integer> nodes=new ArrayList<>();
        public boolean visit=false;
        public Graph(){
            nodes=new ArrayList<>();
            visit=false;
        }
        void clear(){
            visit=false;
        }


    }
}
