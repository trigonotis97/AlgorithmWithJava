package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11052 { //Main

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());
        int []costs =new int[n];
        int []maxCosts = new int[n+1];

        //tring [] costString =br.readLine().split(" ");
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i =0;i<n;i++){
            costs[i]=Integer.parseInt(st.nextToken());
        }
      /*
        for( int i=0;i<n;i++){
            maxCosts[i+1]=costs[i]=Integer.parseInt(costString[i]);
        }

       */
        maxCosts[1]=costs[0];
        for(int i=2;i<n+1;i++){
            maxCosts[i]=costs[i-1];
            for(int j=i-1;j>=i/2;j--){
                maxCosts[i]=Math.max(maxCosts[i],maxCosts[j]+maxCosts[i-j]);
            }
        }
        bw.write(Integer.toString(maxCosts[n]));
        br.close();
        bw.flush();
        bw.close();
    }

}
