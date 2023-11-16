import java.util.*;
import java.io.*;

// 14916 : 거스름돈

/**
 * Example
 * 13
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14916_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        final int INF = 100_000_000;
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.min(dp[i - 2], ((5 <= i) ? dp[i - 5] : Integer.MAX_VALUE)) + 1;
        }

        System.out.println(INF <= dp[N] ? -1 : dp[N]);
    }
}