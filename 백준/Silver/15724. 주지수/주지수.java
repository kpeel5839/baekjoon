import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15724 : 주지수

/**
 * Example
 * 4 4
 * 9 14 29 7
 * 1 31 6 13
 * 21 26 40 16
 * 8 38 11 23
 * 3
 * 1 1 3 2
 * 1 1 1 4
 * 1 1 4 4
 */
public class Main {

    public static int H;
    public static int W;
    public static int[][] arr;
    public static int[][] prefixSum;

    public static void initPrefixSum() {
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }
    }

    public static int sumOfRange(int y1, int x1, int y2, int x2) {
        return prefixSum[y2][x2] - prefixSum[y2][x1 - 1] - prefixSum[y1 - 1][x2] + prefixSum[y1 - 1][x1 - 1];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_15724_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[H + 1][W + 1];
        prefixSum = new int[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initPrefixSum();
        StringBuilder ans = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            ans.append(
                    sumOfRange(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            ).append("\n");
        }

        System.out.println(ans);
    }
}