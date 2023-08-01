import java.util.*;
import java.io.*;

// 14248 : 점프 점프

/**
 * Example
 * 5
 * 1 4 2 2 1
 * 3
 */
public class Main {
    public static int N;
    public static int ans;
    public static int[] arr;
    public static boolean[] visited;

    public static boolean outOfRange(int index) {
        return index < 0 || N <= index;
    }

    public static void dfs(int index) {
        if (outOfRange(index) || visited[index]) {
            return;
        }

        ans++;
        visited[index] = true;
        dfs(index - arr[index]);
        dfs(index + arr[index]);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14248_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        int S = Integer.parseInt(br.readLine()) - 1;
        dfs(S);
        System.out.println(ans);
    }
}