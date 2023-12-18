import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15489 : 파스칼 삼각형

/**
 * Example
 * 3 1 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_15489_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[][] pascal = new long[29][29];

        int R = Integer.parseInt(st.nextToken()) - 1;
        int C = Integer.parseInt(st.nextToken()) - 1;
        int W = Integer.parseInt(st.nextToken());

        pascal[0][0] = 1;

        for (int i = 1; i < pascal.length; i++) {
            for (int j = 0; j < pascal[i].length; j++) {
                pascal[i][j] = pascal[i - 1][j] + (j == 0 ? 0 : pascal[i - 1][j - 1]);
            }
        }

        int loopCount = 1;
        long sum = 0;
        for (int i = R; i < R + W; i++) {
            for (int j = C; j < C + loopCount; j++) {
                sum += pascal[i][j];
            }

            loopCount++;
        }

        System.out.println(sum);
    }
}