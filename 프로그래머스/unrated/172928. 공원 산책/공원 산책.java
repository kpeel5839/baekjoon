import java.util.*;
import java.io.*;

class Solution {
    
	public int H;
    public int W;
    public char[][] map;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    public Map<Character, Integer> m = Map.of(
            'N', 0,
            'E', 1,
            'S', 2,
            'W', 3
    );
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    
    public int[] solution(String[] park, String[] routes) {
                H = park.length;
        W = park[0].length();
        map = new char[H][W];
        int y = 0;
        int x = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = park[i].charAt(j);

                if (map[i][j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }

        // map 까지 있고
        Loop:
        for (String route : routes) {
            String[] s = route.split(" ");

            int direction = m.get(s[0].charAt(0));
            int count = Integer.parseInt(s[1]);
            int ny = y;
            int nx = x;

            for (int i = 0; i < count; i++) {
                ny += dy[direction];
                nx += dx[direction];

                if (outOfRange(ny, nx) || map[ny][nx] == 'X') {
                    continue Loop;
                }
            }

            y = ny;
            x = nx;
        }

        return new int[] {y, x};
    }
}