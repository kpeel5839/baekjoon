import java.util.*;
import java.io.*;

// 15990 : 1, 2, 3 더하기 5

/**
 * Example
 * 3
 * 4
 * 7
 * 10
 */
public class Main {

    public static int N = 100_000;
    public static int[][] dp;
    public static int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15990_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        dp = new int[4][N + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j < 0) {
                    continue;
                }
                for (int c = 0; c <= 3; c++) {
                    if (j == c) {
                        continue;
                    }

                    dp[j][i] = (dp[j][i] + dp[c][i - j]) % MOD;
                }
            }
        }

        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 1; i <= 3; i++) {
                sum = (sum + dp[i][num]) % MOD;
            }
            ans.append(sum).append("\n");
        }

        System.out.println(ans);
    }
}