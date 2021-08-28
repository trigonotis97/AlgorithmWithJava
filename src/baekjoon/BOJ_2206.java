package baekjoon; // delete this

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/2206
public class BOJ_2206 {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xy = new int[2];
        String[][] graph = new String[1002][1002];
        int[][][] minGraph = new int[1002][1002][2];
        int min = 10000000;
        String[] s = br.readLine().split(" ");
        for (int j = 0; j < 2; j++) {
            xy[j] = Integer.parseInt(s[j]);
        }


        // graph input
        for (int j = 0; j < xy[0]; j++) {
            String tmp = br.readLine();
            for (int k = 0; k < xy[1]; k++) {
                graph[j+1][k+1] = Character.toString(tmp.charAt(k));
            }
        }

        //search
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> que = new LinkedList<>();
        int[] arr = new int[]{1, 1, 0};
        que.add(arr);
        minGraph[1][1][0] = 1;
        int ans = 1;
        int nx, ny, nwall;
        for (; ; ) {
            int[] vert = que.poll();
            for (int[] d : dir) {
                ny = vert[1] + d[1];
                nx = vert[0] + d[0];
                nwall = vert[2];


                //범위체크
                if (nx >= 1 && ny >= 1 && nx <= xy[0] && ny <= xy[1]) {
                    if(minGraph[nx][ny][nwall] != 0)
                        continue;
                    //벽 체크, 방문체크
                    if (graph[nx][ny].equals("0")) {
                        que.add(new int[]{nx, ny, nwall});
                        minGraph[nx][ny][nwall] = minGraph[vert[0]][vert[1]][vert[2]] + 1;
                    } else { //벽있을때
                        if (nwall == 0) {
                            nwall = 1;
                            que.add(new int[]{nx, ny, nwall});
                            minGraph[nx][ny][nwall] = minGraph[vert[0]][vert[1]][vert[2]] + 1;
                        }
                    }

                }
                if(vert[0]==xy[0]&&vert[1]==xy[1]){
                    System.out.println(minGraph[xy[0]][xy[1]][vert[2]]);
                    return;
                }
            }
            if (que.isEmpty()) {
                System.out.println(-1);
                break;
            }


        }



    }
}
