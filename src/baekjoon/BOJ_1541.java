package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int result=0;
        int buffer=0;
        String[] strNum = s.split("[+-]");
        int ind=0;
        result+=Integer.parseInt(strNum[ind++]);
        for(char c : s.toCharArray()){
            if(!(c>='0' && c<='9')){
                if(c=='+'&&buffer==0){
                    result+=Integer.parseInt(strNum[ind++]);
                }
                else if(c=='+'&&buffer!=0){
                    buffer += Integer.parseInt(strNum[ind++]);
                }
                else if(c=='-'&&buffer==0){
                    buffer += Integer.parseInt(strNum[ind++]);
                }
                else if(c=='-' && buffer!=0){
                    result -= buffer;
                    buffer = Integer.parseInt(strNum[ind++]);
                }
            }
        }
        if(buffer!=0) result -= buffer;
        System.out.println(result);
    }
}
