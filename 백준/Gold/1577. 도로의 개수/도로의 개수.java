import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

// 1577 : 도로의 개수

/**
 * Example
 * 6 6
 * 2
 * 0 0 0 1
 * 6 6 5 6
 */
public class Main {

    public static int H;
    public static int W;
    public static int[] dx = new int[] {-1, 0};
    public static int[] dy = new int[] {0, 1};
    public static Set<Path> isImpossibleRoute = new HashSet<>();
    public static long[][] dp;

    public static boolean isOutOfRange(int y, int x) {
        return y < 0 || y > H || x < 0 || x > W;
    }

    public static class Path {
        public int sy;
        public int sx;
        public int dy;
        public int dx;

        private Path(int sy, int sx, int dy, int dx) {
            this.sy = sy;
            this.sx = sx;
            this.dy = dy;
            this.dx = dx;
        }

        public static Path of(int y1, int x1, int y2, int x2) {
            if (x1 == x2) {
                if (y1 < y2) {
                    return new Path(y1, x1, y2, x2);
                }

                return new Path(y2, x2, y1, x1);
            }

            if (x1 > x2) {
                return new Path(y1, x1, y2, x2);
            }

            return new Path(y2, x2, y1, x1);
        }

        @Override
        public boolean equals(Object o) {
            Path path = (Path) o;

            return path.sy == this.sy
                    && path.sx == this.sx
                    && path.dy == this.dy
                    && path.dx == this.dx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sy, sx, dy, dx);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1577_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new long[H + 1][W + 1];

        int impossibleRouteCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < impossibleRouteCount; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = H - Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = H - Integer.parseInt(st.nextToken());

            isImpossibleRoute.add(Path.of(y1, x1, y2, x2));
        }

        dp[H][0] = 1;
        for (int i = H; 0 <= i; i--) {
            for (int j = 0; j <= W; j++) {
                for (int direction = 0; direction < 2; direction++) {
                    int ny = i + dy[direction];
                    int nx = j + dx[direction];

                    if (isOutOfRange(ny, nx) || isImpossibleRoute.contains(Path.of(i, j, ny, nx))) {
                        continue;
                    }

                    dp[i][j] += dp[ny][nx];
                }
            }
        }

        System.out.println(dp[0][W]);
    }
}