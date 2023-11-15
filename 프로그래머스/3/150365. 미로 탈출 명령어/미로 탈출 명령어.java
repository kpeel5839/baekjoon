import java.util.*;

class Solution {
    
    public int H;
    public int W;
    public int K;
    public int r1;
    public int c1;
    public int r2;
    public int c2;
    public boolean[][][] visited;
    public int[][][] track;
    public int[] dx = {0, -1, 1, 0};
    public int[] dy = {1, 0, 0, -1};
    public String answer = "impossible";
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }
    
    public void dfs(int y, int x, int count, int preDir) {
        if (!answer.equals("impossible")) {
            return;
        }
        
        if (visited[count][y][x]) {
            return;
        }
        
        visited[count][y][x] = true;
        track[count][y][x] = preDir;
        
        if (count == K) {
            if (y == r2 && x == c2) {
                answer = tracking();
            }
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            int nCount = count + 1;
            
            if (outOfRange(ny, nx)) {
                continue;
            }
            
            dfs(ny, nx, nCount, i);
        }
    }
    
    public String tracking() {
        StringBuilder ans = new StringBuilder();
        int count = K;
        int r = r2;
        int c = c2;
        
        while (count != 0) {
            int dir = track[count][r][c]; // 현재 여기로 오기 위해서 이동했던 방향, 그의 반대 방향으로 가주어야함
            
            if (dir == 0) {
                r--;
                ans.append("d");
            } else if (dir == 1) {
                c++;
                ans.append("l");
            } else if (dir == 2) {
                c--;
                ans.append("r");
            } else {
                r++;
                ans.append("u");
            }
            
            count--;
        }
        
        return ans.reverse().toString();
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.H = n;
        this.W = m;
        this.K = k;
        this.r1 = x - 1;
        this.c1 = y - 1;
        this.r2 = r - 1;
        this.c2 = c - 1;
        
        visited = new boolean[K + 1][H][W];
        track = new int[K + 1][H][W];
        dfs(r1, c1, 0, -1);
        return answer;
    }
    
}