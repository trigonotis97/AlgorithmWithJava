package programmers;

public class OctoberSol1 {

    public static void main(String[] args) {
        System.out.print(new OctoberSol1().solution2(new int[][]{{1,1,0,0}, {1,0,0,0},{1,0,0,1},{1,1,1,1}}).toString());
    }
    int solution(int n) {
        int answer = 0;
        String numStr=  Integer.toString(n,3);
        String revStr=new StringBuffer(numStr).reverse().toString();
        answer=Integer.parseInt(revStr,3);
        return answer;
    }

    int[] solution2 (int[][] arr) {
        int[] answer = {};
        this.arr=arr;
        result=new int[] {0,0};
        recursion(0,0,arr[0].length);



        return answer;
    }
    int [][] arr;
    int [] result;
    void recursion(int x, int y, int size){
        int head=arr[x][y];
        int i=x;
        int j=y;


        for (i = x; i <x+size ; i++) {
            for (j = y; j < y+size; j++) {
                if(head!=arr[i][j]){
                    int halfSize=size/2;
                    recursion(x,y,halfSize);
                    recursion(x,y+halfSize,halfSize);
                    recursion(x+halfSize,y,halfSize);
                    recursion(x+halfSize,y+halfSize,halfSize);
                    return;
                }
            }
        }


        result[head]++;

    }

}

