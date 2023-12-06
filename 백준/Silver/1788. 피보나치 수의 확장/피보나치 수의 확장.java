import java.util.*;
import java.io.*;

// 1788 : 피보나치 수의 확장

/**
 * Example
 * -2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1788_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0 + "\n" + 0);
            return;
        }

        int MAX = 1_000_000;
        int[] dp = new int[MAX * 2 + 1];
        final int MOD = 1_000_000_000;
        dp[MAX + 1] = 1;

        for (int i = MAX + 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        for (int i = MAX - 1; 0 <= i; i--) {
            dp[i] = (dp[i + 2] - dp[i + 1]) % MOD;
        }

        if (dp[N + MAX] < 0) {
            System.out.println(-1);
        } else if (dp[N + MAX] == 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        System.out.println(Math.abs(dp[N + MAX]));
    }
}