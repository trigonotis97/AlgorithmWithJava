package programmers;

public class sol3 {
    public static void main(String[] args) {
        int re=Solution.solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33});
        int ree=Solution.solution(new int[]{9,-1,-5});
    }

   static class Solution {
        static public int solution(int[] a) {
            int []arr=new int[a.length];//
            int answer = 0;
            int frontMin=0,backMin=0;
            for (int i = 0; i < a.length; i++) {
                if(i==0){
                    answer+=1;
                    frontMin=a[i];
                    arr[i]=a[i];
                    continue;
                }

                else if(frontMin>a[i]){
                    frontMin=a[i]; //0
                    answer+=1;
                    arr[i]=a[i];
                    continue;
                }
                //1


                if(backMin<a[i]){

                }
                else {
                    backMin = 1000000111;
                    for (int j = i + 1; j < a.length; j++) {
                        if (backMin> a[j]) {
                            backMin=a[j];
                        }
                    }
                }

                if (frontMin>a[i]||backMin>a[i]) {
                    answer += 1;
                    arr[i]=a[i];//
                }
            }

            return answer;
        }
    }

}
