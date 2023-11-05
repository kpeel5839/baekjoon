import java.util.*;
import java.io.*;

// 15988 : 1, 2, 3 더하기 3

/**
 * Example
 * 3
 * 4
 * 7
 * 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15988_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[1_000_001];
        final int MOD = 1_000_000_009;
        int N = Integer.parseInt(br.readLine());
        dp[0] = 1;

        for (int i = 1; i <= 1_000_000; i++) {
            for (int j = 1; j <= 3; j++) {
                dp[i] = (dp[i] + (i - j < 0 ? 0 : dp[i - j])) % MOD;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            ans.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(ans);
    }
}