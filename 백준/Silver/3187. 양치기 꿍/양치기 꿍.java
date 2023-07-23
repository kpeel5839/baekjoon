import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    static int R,C;
    static char arr[][];
    static boolean visit[][];
    static int moveX[] = {0,1,0,-1};
    static int moveY[] = {-1,0,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[R][C];
        visit = new boolean[R][C];
        int sheep = 0;
        int wolf = 0;
        for(int r=0; r<R; r++) {
            String str = br.readLine();
            for(int c=0; c<C; c++) {
                arr[r][c] = str.charAt(c);
            }
        }
        for(int r=0; r<R; r++) {
            for(int c=0; c<C; c++) {
                if(arr[r][c] != '#' && !visit[r][c]) {
                    Point po = bfs(r,c);
                    wolf += po.x;
                    sheep += po.y;
                }
            }
        }
        System.out.println(sheep +" " +wolf);
    }
    private static Point bfs(int row, int col) {
        // TODO Auto-generated method stub
        Queue<Point> queue = new LinkedList<Point>();
        visit[row][col] = true;
        queue.add(new Point(col, row));
        int sheep = 0;
        int wolf = 0;
        while(!queue.isEmpty()) {
            Point po = queue.poll();
            if(arr[po.y][po.x] == 'v')
                wolf++;
            else if(arr[po.y][po.x] == 'k')
                sheep++;
            
            for(int d=0; d<4; d++) {
                int newY = po.y + moveY[d];
                int newX = po.x + moveX[d];
                
                if(0<=newY && newY<R && 0<=newX && newX<C && !visit[newY][newX] && arr[newY][newX] != '#') {
                    visit[newY][newX] = true;
                    queue.add(new Point(newX, newY));
                }
            }
        }
        if(wolf>=sheep) {
            sheep = 0;
        }else {
            wolf = 0;
        }
        
        return new Point(wolf, sheep);
    }
}