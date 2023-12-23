import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 14606 : 피자 (Small)

/**
 * Example
 * 3
 */
public class Main {

    public static int N;
    public static int[] dp;

    public static int dfs(int remain) {
        if (remain == 1) {
            return 0;
        }

        if (dp[remain] != -1) {
            return dp[remain];
        }

        dp[remain] = 0;

        for (int i = 1; i < remain; i++) {
            dp[remain] = Math.max(dp[remain], dfs(i) + dfs(remain - i) + (i * (remain - i)));
        }

        return dp[remain];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_14606_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println(dfs(N));
    }
}