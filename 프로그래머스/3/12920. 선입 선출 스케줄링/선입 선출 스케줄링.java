import java.util.*;

class Solution {
    int N;
    int INF=1_000_000_000;
    int[] c;
    public int check(long time){
        List<Integer> complete=new ArrayList<>();
        int cnt=0;
        for(int i=0;i<c.length;i++){
            cnt+=time/c[i]+1;
            if(time%c[i]==0){
                complete.add(i);
            }
        }
        if(cnt<N){//오른쪽
            return INF;
        }else if(cnt-N+1<=complete.size()){//답
            return complete.get(complete.size()-1-(cnt-N))+1;
        }
        return -INF;
    }
    public int solution(int n, int[] cores) {
        this.N=n;
        this.c=cores;
       	int maxC=0;
        for(int i=0;i<c.length;i++){
            maxC=Math.max(maxC,c[i]);
        }
        int l=0;
        int r=(n-1)*maxC;
        while(l<=r){
            int m=(l+r)/2;
            int result=check(m);
            if(result==-INF){
                r=m-1;
            }else if(result==INF){
                l=m+1;
            }else{
                return result;
            }
        }
        return -1;
    }
}