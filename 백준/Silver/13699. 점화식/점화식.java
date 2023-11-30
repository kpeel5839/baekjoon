import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 13699 : 점화식

/**
 * Example
 * 25
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_13699_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N + 1];
        dp[0] = BigInteger.ONE;

        for (int i = 1; i <= N; i++) {
            dp[i] = BigInteger.ZERO;
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i].add(dp[j].multiply(dp[i - j - 1]));
            }
        }

        System.out.println(dp[N]);
    }
}