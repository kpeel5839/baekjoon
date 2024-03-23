import java.util.*;
class Solution {
    List<List<int[]>>po;
    int h;
    int w;
    int answer;
    int max;
    int[][] board;
    boolean isOutOfRange(int y,int x){
        return y<0||y>=h||x<0||x>=w;
    }
    int[] dx={0,1,0,-1};
    int[] dy={-1,0,1,0};
    boolean[] visited;
    public int bfs(int y,int x, int desY,int desX){
        Queue<int[]>q=new LinkedList<>();//{y,x,distance}
        boolean[][] vis=new boolean[h][w];
        q.add(new int[]{y,x,0});
        vis[y][x]=true;
        while(!q.isEmpty()){
            int[] p=q.poll();
            if(desY==p[0]&&desX==p[1]){
                return p[2];
            }
            for(int i=0;i<4;i++){
                //바로앞방향
                int dny=p[0]+dy[i];
                int dnx=p[1]+dx[i];
                if(!isOutOfRange(dny,dnx)&&!vis[dny][dnx]){
                    vis[dny][dnx]=true;
                    q.add(new int[]{dny,dnx,p[2]+1});
                }
                //끝방향
                int ddny=p[0];
                int ddnx=p[1];
                for(int j=0;j<4;j++){
                    if(isOutOfRange(ddny+dy[i],ddnx+dx[i])){
                        break;
                    }
                    ddny+=dy[i];
                    ddnx+=dx[i];
                    if(board[ddny][ddnx]!=0&&!visited[board[ddny][ddnx]]){
                        break;
                    }
                }
                if(!isOutOfRange(ddny,ddnx)&&!vis[ddny][ddnx]){
                    vis[ddny][ddnx]=true;
                    q.add(new int[]{ddny,ddnx,p[2]+1});
                }
            }
        }
        return -1;
    }
    public void solve(int idx,int y,int x,int distance){
        if(idx==max){
            answer=Math.min(answer,distance);
            return;
        }
        for(int i=1;i<=max;i++){
            if(visited[i]){
                continue;
            }
            int[] p1=po.get(i).get(0);
            int[] p2=po.get(i).get(1);
            //기존의 위치에서 ->0->1,->1->0
            int distance1=bfs(y,x,p1[0],p1[1])+bfs(p1[0],p1[1],p2[0],p2[1]);
            visited[i]=true;
            solve(idx+1,p2[0],p2[1],distance+distance1);
            visited[i]=false;
            int distance2=bfs(y,x,p2[0],p2[1])+bfs(p2[0],p2[1],p1[0],p1[1]);
            visited[i]=true;
            solve(idx+1,p1[0],p1[1],distance+distance2);
            visited[i]=false;
        }
    }
    public int solution(int[][] board, int r, int c) {
        answer=Integer.MAX_VALUE;
        h=board.length;
        w=board[0].length;
        this.board=board;
        max=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                max=Math.max(max,board[i][j]);
            }
        }
        po=new ArrayList<>();
        for(int i=0;i<=max;i++){
            po.add(new ArrayList<>());
        }
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(board[i][j]!=0){
                    po.get(board[i][j]).add(new int[]{i,j});
                }
            }
        }
        visited=new boolean[max+1];
        solve(0,r,c,0);
        return answer+max*2;
    }
}