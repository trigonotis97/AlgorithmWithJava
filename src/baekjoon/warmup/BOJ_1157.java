package baekjoon.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1157 {
/*

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String singleLetter="";
        int maxCount=0;
        String result="";
        Map<String,Integer> map=new HashMap<>();
        do{
           singleLetter=(String.valueOf(s.charAt(0))).toLowerCase();
           if(!map.containsKey(singleLetter)){
               map.put(singleLetter,1);
           }
           else {
               map.replace(singleLetter,map.get(singleLetter)+1);
           }
            if(s.length()==1)
                break;
            s=s.substring(1);
        }while (true);
        int [] arr=new int[map.size()];
        int i=0;
        for(Object o : map.keySet()){
            arr[i++]=map.get(o);
        }
        Arrays.sort(arr);
        if(arr[arr.length-1]==arr[arr.length-2])
            System.out.print("?");
        else {
            for(Object o : map.keySet()){
                if(map.get(o)==arr[arr.length-1]){
                    System.out.print((String)o);
                    break;
                }
            }
        }

    }

 */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();

        int [] counter =new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[Character.toLowerCase(s.charAt(i))-'a']++;
        }
        int max=0;
        for (int value : counter) {
            if (max < value)
                max = value;
        }
        char result=' ';
        for(int i=0; i< counter.length;i++){
            if(max==counter[i] && result==' '){
                result=(char)('a'+i);
            }
            else if(max==counter[i]){
                System.out.print("?");
                return;
            }

        }
        System.out.print(Character.toUpperCase(result));

    }

    class Solution {
        public int[] solution(int n) {
            int [][] arr =new int[n][n];
            int direction=0;
            int x=0,y=0,count=1,maxCount=0;
            for (int i = 1; i <=n; i++) {
                maxCount+=i;
            }
            int[] answer = new int[maxCount];

            outer:
            do{
                switch (direction){
                    case 0:
                        if(maxCount==count)
                            break outer;
                        arr[x][y]=count++;
                        if(x+1>=n-1 ||arr[x+1][y]!=0)
                            direction++;
                        else
                            x+=1;
                        break;
                    case 1:
                        if(maxCount==count)
                            break outer;
                        arr[x][y]=count++;
                        if(y+1>=n-1 ||arr[x][y+1]!=0)
                            direction++;
                        else
                            y+=1;
                        break;
                    case 2:
                        if(maxCount==count)
                            break outer;
                        arr[x][y]=count++;
                        if(arr[x-1][y-1]!=0)
                            direction=0;
                        else
                            x--; y--;
                        break;

                }
            }while (true);
            count=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]!=0)
                        answer[count++]=arr[i][j];
                }
            }

            return answer;
        }
    }
}
