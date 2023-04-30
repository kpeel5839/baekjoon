import java.util.*;
import java.io.*;

// 16975 : 수열과 쿼리 21

/**
 * Example
 * 5
 * 1 2 3 4 5
 * 4
 * 1 3 4 6
 * 2 3
 * 1 1 3 -2
 * 2 3
 */
public class Main {
    public static long[] tree;
    public static long[] lazy;
    public static int height;

    public static void init() {
        for (int i = height - 1; 0 <= i; i--) {
            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
                tree[j] = tree[j * 2] + tree[j * 2 + 1];
            }
        }
    }

    public static void updateRange(int c, int v, int l, int r, int ul, int ur) {
        updateLazy(c, l, r);

        if (r < ul || ur < l) {
            return;
        }

        if (ul <= l && r <= ur) {
            tree[c] += ((long) (r - l + 1) * v);

            if (l != r) {
                lazy[c * 2] += v;
                lazy[c * 2 + 1] += v;
            }

            return;
        }

        updateRange(c * 2, v, l, (l + r) / 2, ul, ur);
        updateRange(c * 2 + 1, v, (l + r) / 2 + 1, r, ul, ur);
    }

    public static void updateLazy(int c, int l, int r) {
        if (lazy[c] != 0) {
            tree[c] += ((r - l + 1) * lazy[c]);

            if (l != r) {
                lazy[c * 2] += lazy[c];
                lazy[c * 2 + 1] += lazy[c];
            }

            lazy[c] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16975_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        height = (int) Math.ceil(Math.log(N) / Math.log(2));
        tree = new long[(int) Math.pow(2, height) * 2];
        lazy = new long[(int) Math.pow(2, height) * 2];

        for (int i = 0; i < N; i++) {
            tree[(int) Math.pow(2, height) + i] = Integer.parseInt(st.nextToken());
        }

        init();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());

            if (operation == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                updateRange(1, v, 1, (int) Math.pow(2, height), a, b);
            } else {
                int x = Integer.parseInt(st.nextToken());
                updateRange(1, 0, 1, (int) Math.pow(2, height), x, x);
                bw.write(tree[(int)Math.pow(2, height) + x - 1] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}