import java.util.*;
import java.io.*;

// 21736 : 헌내기는 친구가 필요해

/**
 * Example
 * 3 5
 * OOOPO
 * OIOOX
 * OOOXP
 */
public class Main {
    public static int H;
    public static int W;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static char[][] map;
    public static boolean[][] visited;
    public static int ans = 0;

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void dfs(int y, int x) {
        if (outOfRange(y, x) || visited[y][x] || map[y][x] == 'X') {
            return;
        }

        if (map[y][x] == 'P') {
            ans++;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            dfs(y + dy[i], x + dx[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_21736_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // O = 빈공간, X = 벽, I = 도연이의 위치, P = 사람
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'I') {
                    dfs(i, j);
                }
            }
        }

        if (ans == 0) {
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
    }
}