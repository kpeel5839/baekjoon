import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// F : Shoot! Take a Paranoma

/**
 * Example
 * 2
 * -1 -1 1 1
 * -1 -1 10
 * 1 1 1
 */
public class Main {

    public static int[][] points;

    public static long getParanoma(int y, int x) {
        long result = 0;

        for (int i = 0; i < points.length; i++) {
            long a = (long) Math.pow(points[i][0] - y, 2);
            long b = (long) Math.pow(points[i][1] - x, 2);
            result += (a + b) * points[i][2];
        }

        return result;
    }

    public static long binaryXAxios(int y, int l, int r) {
        long minResult = Long.MAX_VALUE;

        while (l <= r) {
            int m = (l + r) / 2;
            minResult = Math.min(minResult, getParanoma(y, m));

            long left = getParanoma(y, m - 1);
            long right = getParanoma(y, m + 1);

            if (left == right) {
                return minResult;
            } else if (left < right) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return minResult;
    }

    public static long binaryYAxios(int x, int l, int r) {
        long minResult = Long.MAX_VALUE;

        while (l <= r) {
            int m = (l + r) / 2;
            minResult = Math.min(minResult, getParanoma(m, x));

            long up = getParanoma(m - 1, x);
            long down = getParanoma(m + 1, x);

            if (up == down) {
                return minResult;
            } else if (up < down) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return minResult;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_2023_First_Trip/_2023_12_23_F/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int xMin = Integer.parseInt(st.nextToken());
        int yMin = Integer.parseInt(st.nextToken());
        int xMax = Integer.parseInt(st.nextToken());
        int yMax = Integer.parseInt(st.nextToken());

        points = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][2] = Integer.parseInt(st.nextToken());
        }

        long result = Long.MAX_VALUE;
        result = Math.min(result, binaryXAxios(yMin - 1, xMin, xMax));
        result = Math.min(result, binaryXAxios(yMax + 1, xMin, xMax));
        result = Math.min(result, binaryYAxios(xMin - 1, yMin, yMax));
        result = Math.min(result, binaryYAxios(xMax + 1, yMin, yMax));
        System.out.println(result);
    }
}