import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 17129 : 윌리암슨수액빨이딱따구리가 정보섬에 올라온 이유

/**
 * Example
 * 3 3
 * 200
 * 003
 * 045
 */
public class Main {
    public static int H;
    public static int W;
    public static int[][] map;
    public static boolean[][] visited;
    public static String SUCCESS = "TAK";
    public static String FAIL = "NIE";
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static Set<Integer> des = Set.of(3, 4, 5);

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y, x, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (des.contains(map[p[0]][p[1]])) {
                return p[2];
            }

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] == 1) {
                    continue;
                }

                q.add(new int[] {ny, nx, p[2] + 1});
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int ans = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 2) {
                    ans = bfs(i, j);
                }
            }
        }

        if (ans == -1) {
            System.out.println(FAIL);
        } else {
            System.out.println(SUCCESS + "\n" + ans);
        }
    }
}