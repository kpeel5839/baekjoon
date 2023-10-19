import java.util.*;
import java.io.*;

// 2193 : 이친수

/**
 * Example
 * 3
 */
public class Main {

    public static int N;
    public static long[][] dp;

    public static long dfs(int index, int prev) {
        if (index == N) {
            return 1;
        }

        if (dp[prev][index] != -1) {
            return dp[prev][index];
        }

        if (prev == 0) {
            dp[prev][index] = dfs(index + 1, 0);
            dp[prev][index] += dfs(index + 1, 1);
        }

        if (prev == 1) {
            dp[prev][index] = dfs(index + 1, 0);
        }

        return dp[prev][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2193_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[2][N];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        System.out.println(dfs(1, 1));
    }
}