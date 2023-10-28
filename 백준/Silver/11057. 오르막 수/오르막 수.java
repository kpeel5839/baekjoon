import java.util.*;
import java.io.*;

// 11057 : 오르막 수

/**
 * Example
 * 1
 */
public class Main {

    public static int N;
    public static int[][] dp;
    public static int MOD = 10_007;

    public static int dfs(int index, int nowNumber) {
        if (index == N) {
            return 1;
        }

        if (dp[nowNumber][index] != -1) {
            return dp[nowNumber][index];
        }

        dp[nowNumber][index] = 0;

        for (int i = nowNumber; i <= 9; i++) {
            dp[nowNumber][index] = (dp[nowNumber][index] + dfs(index + 1, i)) % MOD;
        }

        return dp[nowNumber][index] % MOD;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11057_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[10][N];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < 10; i++) {
            ans = (ans + dfs(1, i)) % MOD;
        }

        System.out.println(ans % MOD);
    }
}