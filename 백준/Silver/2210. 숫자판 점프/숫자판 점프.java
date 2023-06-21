import java.util.*;
import java.io.*;

// 2210 : 숫자판 점프

/**
 * Example
 * 1 1 1 1 1
 * 1 1 1 1 1
 * 1 1 1 1 1
 * 1 1 1 2 1
 * 1 1 1 1 1
 */
public class Main {

    public static int[][] arr;
    public static Set<String> set = new HashSet<>();
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= 5 || x < 0 || x >= 5;
    }

    public static void dfs(int y, int x, String value) {
        if (value.length() == 6) {
            set.add(value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (outOfRange(ny, nx)) {
                continue;
            }

            dfs(ny, nx, value + arr[ny][nx]);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2210_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "");
            }
        }

        System.out.println(set.size());
    }
}