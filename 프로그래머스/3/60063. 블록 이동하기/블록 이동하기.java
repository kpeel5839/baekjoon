import java.util.*;

class Solution {
    
    public int H;
    public int W;
    public int[][] board;
    public boolean[][][] visited;
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public int[][] ddy = {{1, -1}, {0, 0}};
    public int[][] ddx = {{0, 0}, {1, -1}};
    
    public boolean isArrive(int y, int x, int robotDir) {
        if (robotDir == 0) { // 가로
            return y == H - 1 && (x + 1) == W - 1;
        }
        
        return (y + 1) == H - 1 && x == W - 1; // 세로
    }
    
    public boolean isPossibleRotate(int y, int x, int pre, int next) {
        int ny = y + ddy[pre][next];
        int nx = x + ddx[pre][next];
        
        if (isOutOfRange(ny, nx)) {
            return false;
        }
        
        int nny = ny + dy[pre];
        int nnx = nx + dx[pre];
            
        if (board[ny][nx] == 1 || board[nny][nnx] == 1) {
            return false;
        }
        
        return true;
    }
    
    public boolean isPossibleMove(int y, int x, int robotDir) { // 현재 로봇이 움직였는데 나갔는지
        if (isOutOfRange(y, x) || board[y][x] == 1) {
            return false;
        }
        
        int ny = y + dy[robotDir];
        int nx = x + dx[robotDir];
        
        if (isOutOfRange(ny, nx) || board[ny][nx] == 1) {
            return false;
        }
        
        return true;
    }
    
    public boolean isOutOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }
    
    public int bfs(int y, int x, int robotDir) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x, robotDir, 0});
        visited[robotDir][y][x] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            // System.out.println("(" + p[0] + ", " + p[1] + "), " + p[2] + ", " + p[3]);
            
            if (isArrive(p[0], p[1], p[2])) {
                return p[3];
            }
            
            for (int j = 0; j < 2; j++) {
                for (int c = 0; c < 2; c++) {
                    if (isPossibleRotate(p[0], p[1], p[2], j)) {
                        int ny = p[0] + ddy[p[2]][j] * j;
                        int nx = p[1] + ddx[p[2]][j] * j;
                        
                        int nny = ny + dy[p[2]] * c;
                        int nnx = nx + dx[p[2]] * c;
                        int nRobotDir = (p[2] + 1) % 2;
                        
                        if (!visited[nRobotDir][nny][nnx]) {
                            q.add(new int[] {nny, nnx, nRobotDir, p[3] + 1});
                            visited[nRobotDir][nny][nnx] = true;
                        }
                    }
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                
                if (isPossibleMove(ny, nx, p[2]) && !visited[p[2]][ny][nx]) {
                    q.add(new int[] {ny, nx, p[2], p[3] + 1});
                    visited[p[2]][ny][nx] = true;
                }
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] board) {
       	this.H = board.length;
        this.W = board[0].length;
        this.board = board;
        this.visited = new boolean[2][H][W];
        
        return bfs(0, 0, 0);
    }
}