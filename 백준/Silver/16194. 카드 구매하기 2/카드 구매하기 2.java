import java.util.*;
import java.io.*;

// 16194 : 카드 구매하기 2

/**
 * Example
 * 4
 * 1 5 6 7
 */
public class Main {

    public static int N;
    public static int[] card;
    public static int[] dp;
    public static int INF = 1_000_000_000;

    public static int dfs(int cardCount) {
        if (N < cardCount) {
            return INF;
        }

        if (N == cardCount) {
            return 0;
        }
        
        if (dp[cardCount] != INF) {
            return dp[cardCount];
        }

        for (int i = 0; i < card.length; i++) {
            dp[cardCount] = Math.min(dp[cardCount], dfs(cardCount + i + 1) + card[i]);
        }

        return dp[cardCount];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16194_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        card = new int[N];

        Arrays.fill(dp, INF);
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < card.length; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(0));
    }
}