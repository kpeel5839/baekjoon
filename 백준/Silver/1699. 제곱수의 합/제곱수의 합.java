import java.util.*;
import java.io.*;

// 1699 : 제곱수의 합

/**
 * Example
 * 11
 */
public class Main {

    public static int N;
    public static int[] dp;
    public static final int INF = 100_000_000;

    public static int dfs(int number) {
        if (N <= number) {
            if (N == number) {
                return 0;
            }
            return INF;
        }

        if (dp[number] != -1) {
            return dp[number];
        }

        int minValue = INF;
        for (int i = (int) Math.sqrt(N); 1 <= i; i--) {
            minValue = Math.min(minValue, dfs(number + (int) Math.pow(i, 2)) + 1);
        }

        dp[number] = minValue;
        // dp[i] = 내가 현재까지의 합이 number 이면 N 을 만들기 까지 걸리는 최소한의 횟수
        return dp[number];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1699_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println(dfs(0));
    }
}