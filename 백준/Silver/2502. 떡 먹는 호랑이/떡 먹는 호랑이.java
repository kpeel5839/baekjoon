import java.util.*;
import java.io.*;

// 2502 : 떡 먹는 호랑이

/**
 * Example
 * 30 100000
 */
public class Main {
    public static int N;
    public static int M;
    public static boolean[][] isImpossible;
    public static int[] ans = new int[] {0, 0};
    public static boolean dfs(int index, int prepre, int pre) {
        if (ans[0] != 0 && ans[1] != 0) {
            return false;
        }

        if (pre < prepre - pre) {
            return isImpossible[index][pre] = true;
        }

        if (index == N - 1) {
            ans[0] = prepre - pre;
            ans[1] = pre;
            return false;
        }

        if (isImpossible[index][pre]) {
            return isImpossible[index][pre];
        }

        return isImpossible[index][pre] = dfs(index + 1, pre, prepre - pre);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2502_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isImpossible = new boolean[N][M + 1];

        for (int i = 1; i <= M; i++) {
            dfs(2, M, i);
        }

        System.out.println(ans[0] + "\n" + ans[1]);
    }
}