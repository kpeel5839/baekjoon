import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 15991 : 1, 2, 3 더하기 6

/**
 * Example
 * 3
 * 4
 * 7
 * 10
 */
public class Main {

    public static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_15991_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int SIZE = 100_001;
        int[] dp = new int[SIZE];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;

        for (int i = 4; i < SIZE; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j * 2 < 0) {
                    continue;
                }

                dp[i] = (dp[i] + dp[i - j * 2]) % MOD;
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            ans.append(dp[n]).append("\n");
        }

        System.out.println(ans);
    }

}