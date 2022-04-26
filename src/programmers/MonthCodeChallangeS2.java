package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonthCodeChallangeS2 {
    public static void main(String[] args) {
        Solution_77886 s = new Solution_77886();
        System.out.println(Arrays.toString(s.solution(new String[]{"1110", "100111100", "0111111010"})));
    }
}

//https://programmers.co.kr/learn/courses/30/lessons/77884
//약수의 개수와 덧셈
class Solution_77884 {
    public int solution(int left, int right) {
        int answer = 0;
        int num = left;
        int count;
        for (int i = left; i <= right; i++) {
            count = 0;
            for (int j = 1; j <= i; j++) {
                if(i%j==0)
                    count++;
            }
            answer+=count%2==0?i:-i;
        }

        return answer;
    }
}

// 출처 : https://train-validation-test.tistory.com/103
//https://programmers.co.kr/learn/courses/30/lessons/77885
//2개이하로 다른 비트
class Solution_77885 {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for(int i = 0; i< answer.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i])>>2;
        }
        return answer;
    }
}

//https://programmers.co.kr/learn/courses/30/lessons/77886
//110옮기기
class Solution_77886 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            StringBuilder str = new StringBuilder();
            int cnt=0;
            //110모두 찾기
            for (int j = 0; j < s[i].length(); j++) {
                str.append(s[i].charAt(j));
                if(str.toString().endsWith("110")){
                    cnt++;
                    str.delete(str.length() - 3, str.length());
                }
            }

            //마지막 0 찾기
            int j; //제일마지막 0위치
            for ( j = str.length()-1; j >=0 ; j--) {
                if(str.charAt(j)=='0') break;
            }
            StringBuilder res =new StringBuilder();
            if(j==-1) { // 모두 1일경유
                while (cnt>0){
                    res.append("110");
                    cnt--;
                }
                res.append(str);
            }
            else{
                for (int k = 0; k < str.length(); k++) {
                    res.append(str.charAt(k));
                    if(j==k){ // 현재인덱스가 가장 마지막 0 일경우
                        while (cnt>0){
                            res.append("110");
                            cnt--;
                        }
                    }
                }
            }
            answer[i] = res.toString();

        }
        return answer;
    }
}