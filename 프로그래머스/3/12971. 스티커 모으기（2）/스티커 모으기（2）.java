import java.util.*;
import java.io.*;

class Solution {
    int[] st;
    int[][][]dp;
    public int solution(int sticker[]) {
        this.st=sticker;
        this.dp=new int[2][2][st.length];
        int answer=st[0];
        dp[1][1][0]=st[0];
        for(int k=1;k<st.length;k++){
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    if(k==st.length-1){
                        if(j==0){
                            dp[i][j][k]=Math.max(dp[i][1][k-1],dp[i][0][k-1]);
                        }else if(i==0&&j==1){
                            dp[i][j][k]=dp[i][0][k-1]+st[k];
                        }
                    }else{
                        if(j==0){
                            dp[i][j][k]=Math.max(dp[i][1][k-1],dp[i][0][k-1]);
                        }else{
                            dp[i][j][k]=dp[i][0][k-1]+st[k];
                        }
                    }
                    answer=Math.max(answer,dp[i][j][k]);
                }
            }
        }
        return answer;
    }
}