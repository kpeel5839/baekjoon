import java.util.*;
import java.io.*;

// 15989 : 1, 2, 3 더하기 4

/**
 * Example
 * 3
 * 4
 * 7
 * 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15989_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[4][10001];

        for (int i = 1; i <= 3; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= 10000; j++) {
                dp[i][j] = dp[i - 1][j] + (j - i < 0 ? 0 : dp[i][j - i]);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            ans.append(dp[3][Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(ans);
    }
}