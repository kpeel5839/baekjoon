import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 5569 : 출근 경로

/**
 * Example
 * 15 15
 */
public class Main {

    public static int H;
    public static int W;
    public static final int MOD = 100_000;
    public static int[][][][] dp;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};

    public static boolean isOutOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static int dfs(int remain, int preDir, int y, int x) {
        if (y == H - 1 && x == W - 1) {
            return 1;
        }

        if (dp[remain][preDir][y][x] != -1) {
            return dp[remain][preDir][y][x];
        }

        dp[remain][preDir][y][x] = 0;

        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (isOutOfRange(ny, nx)) {
                continue;
            }

            if (i == preDir) {
                dp[remain][preDir][y][x] = (dp[remain][preDir][y][x] + dfs(Math.max(0, remain - 1), i, ny, nx)) % MOD;
                continue;
            }

            if (remain != 0) {
                continue;
            }

            dp[remain][preDir][y][x] = (dp[remain][preDir][y][x] + dfs(1, i, ny, nx)) % MOD;
        }

        return dp[remain][preDir][y][x];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_5569_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        dp = new int[2][2][H][W];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int c = 0; c < H; c++){
                    Arrays.fill(dp[i][j][c], -1);
                }
            }
        }

        System.out.println((dfs(0, 0, 1, 0) + dfs(0, 1, 0, 1)) % MOD);
    }
}