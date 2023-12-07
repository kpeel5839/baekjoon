import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

// 2688 : 줄어들지 않아

/**
 * Example
 * 3
 * 2
 * 3
 * 4
 */
public class Main {

    public static int N;
    public static long[][] dp;

    public static long dfs(int pre, int index) {
        if (index == N) {
            return 1;
        }

        if (dp[pre][index] != -1) {
            return dp[pre][index];
        }

        dp[pre][index] = 0;

        for (int i = 0; i <= 9; i++) {
            if (pre <= i) {
                dp[pre][index] += dfs(i, index + 1);
            }
        }

        return dp[pre][index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_2688_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            dp = new long[10][N];

            for (int i = 0; i < 10; i++) {
                Arrays.fill(dp[i], -1);
            }

            sb.append(dfs(0, 0)).append("\n");
        }

        System.out.println(sb);
    }
}