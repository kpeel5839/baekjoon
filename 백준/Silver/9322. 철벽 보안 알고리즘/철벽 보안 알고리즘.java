import java.util.*;
import java.io.*;

// 9322 : 철벽 보안 알고리즘

/**
 * Example
 * 2
 * 4
 * A B C D
 * D A B C
 * C B A P
 * 3
 * SECURITY THROUGH OBSCURITY
 * OBSCURITY THROUGH SECURITY
 * TOMORROW ATTACK WE
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9322_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            String[] ans = new String[N];
            Map<String, Integer> m = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                m.put(st.nextToken(), i);
            }

            Map<Integer, Integer> move = new HashMap<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                String s = st.nextToken();
                move.put(i, m.get(s));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ans[move.get(i)] = st.nextToken();
            }

            for (String s : ans) {
                bw.write(s + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}