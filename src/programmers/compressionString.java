package programmers;

public class compressionString {
    public int solution(String s) {
        int answer = s.length();
        String buffer="";
        for(int i=1;i<s.length()/2;i++){
            int count=0,bufCount=0;

            buffer=s.substring(0,i);
            bufCount+=i;
            for(int j=i;;j+=i){
                if(buffer .equals(s.substring(j,j+i)))
                    bufCount++;
                else {
                    buffer = s.substring(j, j + i);
                    if(bufCount==0) count+=i;
                    else {
                        count += i + 1;
                        bufCount = 0;
                    }
                }
                if(j+i>s.length())
                    count+=s.length();
            }
            answer=Math.min(answer,count);
        }
        return answer;
    }
}
