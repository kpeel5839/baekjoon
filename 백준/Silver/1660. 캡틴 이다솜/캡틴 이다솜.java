import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1660 : 캡틴 이다솜

/**
 * Example
 * 91
 */
public class Main {

    public static int N;
    public static int[] dp;
    public static List<Integer> rock;
    public static int INF = 1_000_000;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1660_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rock = new ArrayList<>();
        dp = new int[N + 1];
        Arrays.fill(dp, INF);

        int add = 1;
        int sum = 1;
        int sumsum = 0;

        while (sumsum <= N) {
            sumsum += sum;
            rock.add(sumsum);
            sum += ++add;
        }

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (Integer value : rock) {
                if (i - value < 0) {
                    break;
                }

                dp[i] = Math.min(dp[i], dp[i - value] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}