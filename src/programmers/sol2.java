package programmers;

public class sol2 {
    public static void main(String[] args) {
        int [] re=Solution.solution(6);
    }

    static class Solution {
        static public int[] solution(int n) {
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
                        if(maxCount<count)
                            break outer;
                        if(arr[x][y]==0)
                            arr[x][y]=count++;
                        if(x+1==n ||arr[x+1][y]!=0)
                            direction++;
                        else
                            x+=1;
                        break;
                    case 1:
                        if(maxCount<count)
                            break outer;
                        if(arr[x][y]==0)
                            arr[x][y]=count++;
                        if(y+1==n ||arr[x][y+1]!=0)
                            direction++;
                        else
                            y+=1;
                        break;
                    case 2:
                        if(maxCount<count)
                            break outer;
                        if(arr[x][y]==0)
                            arr[x][y]=count++;
                        if(arr[x-1][y-1]!=0){
                            direction=0;
                            break;
                        }
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
