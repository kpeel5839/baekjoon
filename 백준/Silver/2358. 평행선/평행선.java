import java.util.*;
import java.io.*;

// 2358 : 평행선

/**
 * Example
 * 4
 * 0 0
 * 10 10
 * 0 10
 * 10 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2358_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> y = new HashMap<>();
        Map<Integer, Integer> x = new HashMap<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int yy = Integer.parseInt(st.nextToken());
            int xx = Integer.parseInt(st.nextToken());

            y.put(yy, y.getOrDefault(yy, 0) + 1);
            x.put(xx, x.getOrDefault(xx, 0) + 1);
        }

        int ans = 0;

        for (Integer next : x.values()) {
            if (2 <= next) {
                ans++;
            }
        }

        for (Integer next : y.values()) {
            if (2 <= next) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}