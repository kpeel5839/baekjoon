import java.util.*;
import java.io.*;

// 16500 : 문자열 판별

public class Main {

    public static int N;
    public static String s;
    public static String[] a;
    public static int[] dp;

    public static boolean equals(int index, String compare) {
        for (int j = 0; j < compare.length(); j++) {
            if (s.length() <= index + j || s.charAt(index + j) != compare.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static int dfs(int index) {
        if (s.length() == index) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = 0;

        for (int i = 0; i < a.length; i++) {
            if (equals(index, a[i]) && dfs(index + a[i].length()) == 1) {
                dp[index] = 1;
            }
        }

        return dp[index];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16500_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        N = Integer.parseInt(br.readLine());
        a = new String[N];
        dp = new int[s.length()];

        Arrays.fill(dp, -1);

        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

        System.out.println(dfs(0));
    }
}