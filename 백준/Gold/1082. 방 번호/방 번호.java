import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 1082 : 방 번호

public class Main {

    public static int N;
    public static int M;
    public static String[] dp;
    public static int[] cost;

    public static String max(String a, String b) {
        if (a.equals("")) {
            return b;
        }

        if (a.length() == b.length()) {
            BigInteger ab = new BigInteger(a);
            BigInteger bb = new BigInteger(b);

            return ab.max(bb).toString();
        }

        return a.length() > b.length() ? a : b;
    }

    public static String dfs(int money) {
        if (money == 0) {
            return "";
        }

        if (dp[money] != null) {
            return dp[money];
        }

        dp[money] = "";

        for (int i = 0; i < N; i++) {
            if (0 <= money - cost[i]) {
                dp[money] = max(dp[money], i + dfs(money - cost[i]));
            }
        }

        return dp[money];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1082_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        dp = new String[M + 1];

        String answer = "0";

        for (int i = 1; i < N; i++) {
            if (0 <= M - cost[i]) {
                answer = max(answer, i + dfs(M - cost[i]));
            }
        }

        System.out.println(answer);
    }

}