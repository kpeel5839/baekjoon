import java.util.*;
import java.io.*;

// 20500 : Ezreal 여눈부터 가네 ㅉㅉ

/**
 * Example
 * 1515
 */
public class Main {

    public static int N;
    public static final int MOD = 1_000_000_007;
    public static int[][] dp;

    public static int dfs(int mod, int index) {
        if (index == N) {
            return mod == 0 ? 1 : 0;
        }

        if (dp[mod][index] != -1) {
            return dp[mod][index];
        }

        dp[mod][index] = 0;
        dp[mod][index] = (dp[mod][index] + dfs((mod + 1) % 3, index + 1)) % MOD;
        dp[mod][index] = (dp[mod][index] + dfs((mod + 2) % 3, index + 1)) % MOD;

        return dp[mod][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_20500_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[4][N];

        for (int i = 0; i < 4; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(2, 1));
    }
}