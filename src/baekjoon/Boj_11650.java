package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader((System.in)));
        int i,n;
        String [] lines;
        Point [] pointArr=null;
        n=Integer.parseInt(bf.readLine());
        pointArr=new Point[n];
        for(i=0;i<n;i++){
            lines=bf.readLine().split(" ");
            pointArr[i]=new Point(Integer.parseInt(lines[0]),Integer.parseInt(lines[1]));
        }
        Arrays.sort(pointArr);

        for (Point point :
                pointArr) {
            System.out.println(point.toString());
        }


    }
}

class Point implements Comparable<Point>{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Point p) {
        if(this.x==p.x){
            if(this.y>p.y){
                return 1;
            }
            else {
                return -1;
            }
        }
        else if(this.x>p.x){
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return this.x+" "+this.y;
    }
}
