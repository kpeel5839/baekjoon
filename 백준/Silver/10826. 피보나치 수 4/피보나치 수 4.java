import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 10826 : 피보나치 수 4

/**
 * Example
 * 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_10826_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N + 1];

        if (N == 0) {
            System.out.println(N);
            return;
        }

        if (N == 1) {
            System.out.println(N);
            return;
        }

        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        System.out.println(dp[N]);
    }
}