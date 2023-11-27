import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 9507 : Generations of Tribbles

/**
 * Example
 * 8
 * 0
 * 1
 * 2
 * 3
 * 4
 * 5
 * 30
 * 67
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9507_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[68];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.TWO;
        dp[3] = BigInteger.valueOf(4l);

        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]).add(dp[i - 3]).add(dp[i - 4]);
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}