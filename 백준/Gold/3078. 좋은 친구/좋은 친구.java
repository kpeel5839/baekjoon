import java.util.*;
import java.io.*;

// 3078 : 좋은 친구

/**
 * Example
 * 4 2
 * IVA
 * IVO
 * ANA
 * TOM
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_3078_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> m = new HashMap<>();
        int[] n = new int[N];

        for (int i = 2; i <= 20; i++) {
            m.put(i, 0);
        }

        for (int i = 0; i < N; i++) {
            n[i] = br.readLine().length();
        }

        int count = 0;
        long ans = 0;

        for (int i = 0; i < N; i++) {
            ans += m.get(n[i]);

            if (count == K) {
                m.put(n[i - K], m.get(n[i - K]) - 1);
                m.put(n[i], m.get(n[i]) + 1);
            } else {
                count++;
                m.put(n[i], m.get(n[i]) + 1);
            }
        }

        System.out.println(ans);
    }
}