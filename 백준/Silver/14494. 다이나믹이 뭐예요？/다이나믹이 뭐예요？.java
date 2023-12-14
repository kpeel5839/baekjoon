import java.util.*;
import java.io.*;

// 14494 : 다이나믹이 뭐에요?

/**
 * Example
 * 3 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_14494_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        final int MOD = 1_000_000_007;
        long[][] dp = new long[H + 1][W + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % MOD;
            }
        }

        System.out.println(dp[H][W]);
    }
}