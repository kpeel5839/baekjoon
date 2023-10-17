import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 11726 : 2 * N 타일링

/**
 * Example
 * 2
 */
public class Main {

    public static int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11726_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[i] += (i - 1 < 0 ? 0 : dp[i - 1]) + (i - 2 < 0 ? 0 : dp[i - 2]) % MOD;
        }

        System.out.println(dp[N] % MOD);
    }
}