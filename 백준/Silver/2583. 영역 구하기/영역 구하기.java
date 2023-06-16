import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// 2583 : 영역 구하기

/**
 * Example
 * 5 7 3
 * 0 2 4 4
 * 1 1 2 5
 * 4 0 6 2
 */
public class Main {

    public static int H;
    public static int W;
    public static boolean[][] paper;
    public static int[] dx = new int[] {0, 1, 0, -1};
    public static int[] dy = new int[] {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        paper[y][x] = true;
        int size = 0;

        while (!q.isEmpty()) {
            size++;
            int[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || paper[ny][nx]) {
                    continue;
                }

                paper[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }

        return size;
    }

    public static void draw(int sy, int sx, int ey, int ex) {
        for (int i = sy; i <= ey; i++) {
            for (int j = sx; j <= ex; j++) {
                paper[i][j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2583_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        paper = new boolean[H][W];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;

            draw(sy, sx, ey, ex);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!paper[i][j]) {
                    ans.add(bfs(i, j));
                }
            }
        }

        ans.sort((o1, o2) -> o1 - o2);
        bw.write(ans.size() + "\n");

        for (Integer next : ans) {
            bw.write(next + " ");
        }

        bw.flush();
        bw.close();
    }
}