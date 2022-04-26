package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_210 {
}


class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //위상 체크
        int [] topology = new int[numCourses];
        List<List<Integer>> graph = new ArrayList< >();
        int [] out=new int[numCourses];


        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int x,y;
        for(int [] p : prerequisites){
            x=p[0];
            y=p[1];
            topology[x]++;
            graph.get(y).add(x);
        }
        int count=0;
        while (count<numCourses){
            boolean courseTaken= false;

            for (int i = 0; i < numCourses; i++) {
                if(topology[i] == 0){
                    List<Integer> list=graph.get(i);
                    for(Integer t  : list){
                        topology[t]--;
                    }

                    topology[i]--;
                    courseTaken=true;
                    out[count]=i;
                    count++;
                }
            }
            if(!courseTaken) break;
        }
        if(count==numCourses)
            return out;
        else
            return new int[0];
    }
}