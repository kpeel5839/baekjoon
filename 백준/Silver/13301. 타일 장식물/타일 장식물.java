import java.util.*;
import java.io.*;

// 13301 : 타일 장식물

/**
 * Example
 * 7
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13301_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];

        if (N == 1) {
            System.out.println(4);
            return;
        }

        dp[1] = 1;
        dp[0] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[N] * 2 + dp[N - 1] * 2);
    }
}