import java.util.*;
import java.io.*;

// 1395 : 스위치

/**
 * Example
 * 4 5
 * 0 1 2
 * 0 2 4
 * 1 2 3
 * 0 2 4
 * 1 1 4
 */
public class Main {

    public static int N;
    public static int height;
    public static int[] tree;
    public static boolean[] lazy;

//    public static void init() {
////        for (int i = 0; i < Math.min(N, (int) Math.pow(2, height)); i++) {
////            tree[(int) Math.pow(2, height) + i] = 1;
////        }
////
////        for (int i = height - 1; 0 <= i; i--) {
////            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
////                tree[j] = tree[j * 2] + tree[j * 2 + 1];
////            }
////        }
//    }

    public static void updateRange(int c, int l, int r, int ul, int ur) {
        updateLazy(c, l, r);

        if (ul <= l && r <= ur) {
            tree[c] = (r - l + 1) - tree[c];

            if (l != r) {
                lazy[c * 2] = !lazy[c * 2];
                lazy[c * 2 + 1] = !lazy[c * 2 + 1];
            }

            return;
        }

        if (r < ul || ur < l) {
            return;
        }

        updateRange(c * 2, l, (l + r) / 2, ul, ur);
        updateRange(c * 2 + 1, (l + r) / 2 + 1, r, ul, ur);
        tree[c] = tree[c * 2] + tree[c * 2 + 1];

    }

    public static void updateLazy(int c, int l, int r) {
        if (lazy[c]) {
            tree[c] = (r - l + 1) - tree[c];

            if (l != r) {
                lazy[c * 2] = !lazy[c * 2];
                lazy[c * 2 + 1] = !lazy[c * 2 + 1];
            }

            lazy[c] = false;
        }
    }

    public static int sum(int c, int l, int r, int sl, int sr) {
        updateLazy(c, l, r);

        if (sl <= l && r <= sr) {
            return tree[c];
        }

        if (r < sl || sr < l) {
            return 0;
        }

        return sum(c * 2, l, (l + r) / 2, sl, sr) +
                sum(c * 2 + 1, (l + r) / 2 + 1, r, sl, sr);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1395_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        height = (int) Math.ceil(Math.log(N) / Math.log(2));
        tree = new int[(int) Math.pow(2, height) * 2];
        lazy = new boolean[(int) Math.pow(2, height) * 2];
//        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                updateRange(1, 1, (int) Math.pow(2, height), a, b);
            } else {
                bw.write(sum(1, 1, (int) Math.pow(2, height), a, b) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
