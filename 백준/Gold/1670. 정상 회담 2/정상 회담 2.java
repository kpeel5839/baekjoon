import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1670 : 정상회담 2

/**
 * Example
 * 8
 */
public class Main {

    public static int N;
    public static int[][] dp;
    public static final int MOD = 987_654_321;

    public static int dfs(int remain, int index) {
        if (N / 2 < remain || N < index) {
            return 0;
        }

        if (index == N) {
            if (remain != 0) {
                return 0;
            }

            return 1;
        }

        if (dp[remain][index] != -1) {
            return dp[remain][index];
        }

        dp[remain][index] = 0;
        dp[remain][index] = (dp[remain][index] + dfs(remain + 2, index + 2)) % MOD;
        dp[remain][index] = (dp[remain][index] + dfs(remain, index + 2)) % MOD;
        if (remain != 0) {
            dp[remain][index] = (dp[remain][index] + dfs(remain - 1, index + 1)) % MOD;
        }
        return dp[remain][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1670_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        dp = new int[N / 2 + 1][N];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 0));
    }
}