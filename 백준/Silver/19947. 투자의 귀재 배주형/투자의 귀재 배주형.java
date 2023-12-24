import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;

// 19947 : 투자의 귀재 배주형

/**
 * Example
 * 95229 3
 */
public class Main {

    public static int[][] dp;
    public static int Y;

    public static int dfs(int money, int year) {
        if (year == Y) {
            return 0;
        }

        if (dp[money][year] != -1) {
            return dp[money][year];
        }

        dp[money][year] = 0;

        for (int i = 1; i <= 5; i += 2) {
            if (Y < year + i) {
                continue;
            }

            dp[money][year] = Math.max(dp[money][year], dfs(money + cal(money, i), year + i) + cal(money, i));
        }

        return dp[money][year];
    }

    public static int cal(int money, int year) {
        BigDecimal[] add = new BigDecimal[] {BigDecimal.ZERO, BigDecimal.valueOf(0.05), BigDecimal.ZERO, BigDecimal.valueOf(0.20), BigDecimal.ZERO, BigDecimal.valueOf(0.35)};
        BigDecimal m = BigDecimal.valueOf(money);

        return (int) Math.floor(m.multiply(add[year]).doubleValue());
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_19947_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int money = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        dp = new int[200_001][Y];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(money + dfs(money, 0));
    }
}