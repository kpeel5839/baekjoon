import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int n, int s) {
        int div=s/n;
        if(div==0){
            return new int[]{-1};
        }
        int mod=s%n;
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            if(i<mod){
                answer[n-1-i]=div+1;
            }else{
                answer[n-1-i]=div;
            }
        }
        return answer;
    }
}