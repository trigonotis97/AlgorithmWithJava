package baekjoon.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String [] result=br.readLine().split(" ");
        if(result.length==0)
            System.out.print(result.length);
        else if(result[0].equals(""))
            System.out.print(result.length-1);
        else
            System.out.print(result.length);

    }
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length*numbers.length+1];
            int count=0;
            Arrays.sort(numbers);
            for (int i = 0; i <numbers.length ; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    if(i==j)
                        continue;
                    else if(answer[numbers[i]+numbers[j]]!=0)
                        continue;

                    answer[numbers[i]+numbers[j]]=1;
                    count++;
                }
            }
            int[] result=new int[count];
            count=0;
            for (int i = 0; i < answer.length; i++) {
                if(answer[i]!=0)
                    result[count++]=i;
            }
                return result;
        }
    }
}
