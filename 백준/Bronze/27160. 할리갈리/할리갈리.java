import java.util.*;
import java.io.*;

// 27160 : 할리갈리

/**
 * Example
 * 3
 * BANANA 2
 * PLUM 4
 * BANANA 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_27160_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> m = new HashMap<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            m.put(s, m.getOrDefault(s, 0) + n);
        }

        boolean success = false;
        for (Integer next : m.values()) {
            if (next == 5) {
                success = true;
                break;
            }
        }

        if (success) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}