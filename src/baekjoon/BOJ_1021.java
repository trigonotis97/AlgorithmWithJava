package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken()); //큐의 크기 (이 수만큼 꽉참)
        int m= Integer.parseInt(st.nextToken()); //뽑아내야하는 원소 개수

        //1: poll
        //2: pollfirst addLast
        //3 : polllast add first
        st= new StringTokenizer(br.readLine());
        int offset=0,count=0;
        for (int i = 0; i < m; i++) {
            int x=Integer.parseInt(st.nextToken());
            //deque.addLast(x);\
            x=x+offset<0 ? x+offset+n+1 : x+offset;

            if(x>n)
                x-=n;
            else if(x<=-n)
                x+=n;
            if(x>n/2){ //오른쪽으로 이동
                count+= n-x+1;
                offset+=count;
            }
            else{//왼똑으로 이동
                count+=x-1;
                offset-=count;
            }
            n--;
            offset--; //항상 앞에서 뽑아주기때문
            if(offset>=n)
                offset-=n;
            else if(offset<=-n)
                offset+=n;

        }
        System.out.println(count);
    }
}

