import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 14495 : 피보나치 비스무리한 수열

/**
 * Example
 * 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_14495_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 3) {
            System.out.println(1);
            return;
        }

        BigInteger[] dp = new BigInteger[N + 1];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;
        dp[3] = BigInteger.ONE;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 3]);
        }

        System.out.println(dp[N]);
    }
}