import java.util.*;
import java.io.*;

// 9656 : 돌게임

/**
 * Example
 * 4
 */
public class Main {

    public static int N;
    public static int[][] dp;

    public static int dfs(int turn, int rock) {
        if (rock <= 0) {
            return 1;
        }

        if (dp[turn][rock] != -1) {
            return dp[turn][rock];
        }

        dp[turn][rock] = (Math.min(dfs((turn + 1) % 2, rock - 1), dfs((turn + 1) % 2, rock - 3)) + 1) % 2;
        return dp[turn][rock];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9656_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[2][N + 1];

        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        System.out.println(dfs(0, N) == 1 ? "SK" : "CY");
    }
}