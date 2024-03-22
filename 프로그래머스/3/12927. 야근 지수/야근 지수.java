import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        for(int i=0;i<n;i++){
            if(pq.isEmpty()){
                break;
            }
            int value=pq.poll();
            value--;
            if(value!=0){
                pq.add(value);
            }
        }
        long answer=0;
        while(!pq.isEmpty()){
            answer+=(long)Math.pow(pq.poll(),2);
        }
        return answer;
    }
}