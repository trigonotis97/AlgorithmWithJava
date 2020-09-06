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
}
