import java.util.*;
import java.io.*;

// 1309 : 동물원

/**
 * Example
 * 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1309_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[3][N + 1];
        int MOD = 9901;
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[0][i] = (dp[0][i - 1] + dp[1][i - 1] + dp[2][i - 1]) % MOD;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans = (ans + dp[i][N]) % MOD;
        }
        System.out.println(ans);
    }
}