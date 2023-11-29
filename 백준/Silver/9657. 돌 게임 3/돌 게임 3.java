import java.util.*;
import java.io.*;

// 9657 : 돌 게임 3

/**
 * Example
 * 6
 */
public class Main {

    public static int[][] dp;
    public static int[] stones = new int[] {1, 3, 4};

    public static int dfs(int turn, int remain) {
        if (remain <= 0) {
            return (turn + 1) % 2;
        }

        if (dp[turn][remain] != -1) {
            return dp[turn][remain];
        }

        dp[turn][remain] = turn == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        for (int stone : stones) {
            if (remain < stone) {
                continue;
            }

            if (turn == 0) {
                dp[turn][remain] = Math.min(dp[turn][remain], dfs(1, remain - stone));
            } else {
                dp[turn][remain] = Math.max(dp[turn][remain], dfs(0, remain - stone));
            }
        }

        return dp[turn][remain];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9657_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[2][N + 1];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        System.out.println(dfs(0, N) == 0 ? "SK" : "CY");
    }
}