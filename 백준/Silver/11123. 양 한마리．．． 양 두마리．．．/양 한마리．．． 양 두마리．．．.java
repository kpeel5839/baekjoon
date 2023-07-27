import java.util.*;
import java.io.*;

// 11123 : 양 한마리... 양 두마리...

/**
 * Example
 * 2
 * 4 4
 * #.#.
 * .#.#
 * #.##
 * .#.#
 * 3 5
 * ###.#
 * ..#..
 * #.###
 */
public class Main {

    public static int H;
    public static int W;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[] {y, x});

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] == '.') {
                    continue;
                }

                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11123_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            visited = new boolean[H][W];
            int count = 0;

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!visited[i][j] && map[i][j] == '#') {
                        count++;
                        bfs(i ,j);
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}