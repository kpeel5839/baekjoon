import java.io.*;

public class Main {

    static StringBuffer s = new StringBuffer();
    static int[][] dp = new int[51][51];

    static void swap(int src, int dst) {
        char temp = s.charAt(src);
        s.setCharAt(src, s.charAt(dst));
        s.setCharAt(dst, temp);
    }

    public static void dps(int[][] dp, int ch, int ta) {
        swap(ch, ta);

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 0;
            if (i < s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) dp[i][i + 1] = 0;
                else dp[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                dp[j][j + i] = Math.min(dp[j + 1][j + i] + 1, dp[j][j + i - 1] + 1);
                if (s.charAt(j + i) == s.charAt(j)) dp[j][j + i] = Math.min(dp[j + 1][j + i - 1], dp[j][j + i]);
                else dp[j][j + i] = Math.min(dp[j + 1][j + i - 1] + 1, dp[j][j + i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.MAX_VALUE;

        s.append(br.readLine().trim());

        dps(dp, 0,0);
        result = dp[0][s.length()-1];

        for (int ch = 0; ch < s.length(); ch++) {
            for (int ta = ch + 1; ta < s.length(); ta++) {
                dps(dp, ch, ta);
                result = Math.min(result, dp[0][s.length() - 1] + 1);
                swap(ch, ta);
            }
        }
        bw.write(result + "\n");
        bw.flush();
    }
}