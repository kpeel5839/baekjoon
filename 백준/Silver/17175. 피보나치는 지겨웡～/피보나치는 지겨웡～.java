import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 17175 : 피보나치는 지겨웡~

/**
 * Example
 * 2
 */
public class Main {

    public static int[] dp;
    public static final int MOD = 1_000_000_007;

    public static int fibonacci(int number) {
        if (number < 2) {
            return 1;
        }

        if (dp[number] != 0) {
            return dp[number];
        }

        dp[number] = (fibonacci(number - 2) + fibonacci(number - 1) + 1) % MOD;
        return dp[number];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_17175_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        System.out.println(fibonacci(N));
    }
}