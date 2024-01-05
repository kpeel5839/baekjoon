import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1727 : 커플 만들기

/**
 * Example
 * 2 1
 * 10 20
 * 15
 */
public class Main {

    public static int[] a;
    public static int[] b;
    public static long[][] dp;
    public static final int INF = Integer.MAX_VALUE;

    public static long dfs(int i, int j) {
        if (j == b.length) {
            return 0;
        }

        if (i == a.length) {
            return INF - 1;
        }

        if (dp[i][j] != INF) {
            return dp[i][j];
        }

        return dp[i][j] = Math.min(dfs(i + 1, j), dfs(i + 1, j + 1) + Math.abs(a[i] - b[j]));
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1727_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int man = Integer.parseInt(st.nextToken());
        int woman = Integer.parseInt(st.nextToken());

        a = new int[man];
        b = new int[woman];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        if (man < woman) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        dp = new long[a.length][b.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 0));
    }
}