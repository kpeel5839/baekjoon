import java.util.*;
import java.io.*;

// 17626 : Four Squares

/**
 * Example
 * 34567
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17626_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 4);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= Math.floor(Math.sqrt(i)); j++) {
                dp[i] = Math.min(dp[i], dp[i - (int) Math.pow(j, 2)] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}