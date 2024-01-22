import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 2550 : 전구

/**
 * Example 5 2 4 1 5 3 4 5 1 3 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_2550_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> m = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            m.put(Integer.parseInt(st.nextToken()), i);
        }

        int[][] arr = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i][0] = m.get(value);
            arr[i][1] = value;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int maxOfDp = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; 0 <= j; j--) {
                if (arr[j][0] < arr[i][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxOfDp = Math.max(maxOfDp, dp[i]);
        }

        List<Integer> list = new ArrayList<>();
        int preValue = Integer.MAX_VALUE;
        for (int i = n - 1; 0 <= i; i--) {
            if (dp[i] == maxOfDp && arr[i][0] < preValue) {
                list.add(arr[i][1]);
                maxOfDp--;
                preValue = arr[i][0];
            }
        }

        Collections.sort(list);
        StringBuilder ans = new StringBuilder();
        ans.append(list.size()).append("\n");

        for (int i = 0; i < list.size(); i++) {
            ans.append(list.get(i)).append(" ");
        }

        System.out.println(ans);
    }
}
