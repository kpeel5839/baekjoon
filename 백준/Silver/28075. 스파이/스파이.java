import java.util.*;
import java.io.*;

// 28075 : 수족관

/**
 * Example
 * 3 10
 * 4 2 2
 * 6 4 2
 */
public class Main {

    public static int N;
    public static int M;
    public static int[][] arr;
    public static int answer;

    public static void dfs(int depth, int preJ, int sum) {
        if (depth == N) {
            if (M <= sum) {
                answer++;
            }

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (preJ == j) {
                    dfs(depth + 1, j, sum + arr[i][j] / 2);
                } else {
                    dfs(depth + 1, j, sum + arr[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_28075_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[2][3];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, -1, 0);
        System.out.println(answer);
    }
}