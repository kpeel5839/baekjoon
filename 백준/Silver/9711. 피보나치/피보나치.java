import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 9711 : 피보나치

/**
 * Example
 * 10
 * 5 10
 * 6 25
 * 10 21
 * 32 43
 * 100 100
 * 50 50
 * 25 25
 * 45 67
 * 109 32
 * 128 128
 */
public class Main {

    public static final String format = "Case #%s: %s";
    public static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_9711_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int index = 1;
        dp = new BigInteger[10001];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= 10000; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        StringBuilder ans = new StringBuilder();

        while (index <= N) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            BigInteger Q = BigInteger.valueOf(Integer.parseInt(st.nextToken()));

            ans.append(String.format(format, index, dp[P].mod(Q))).append("\n");
            index++;
        }

        System.out.println(ans);
    }

}