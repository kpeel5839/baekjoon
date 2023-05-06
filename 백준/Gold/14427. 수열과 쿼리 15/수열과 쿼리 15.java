import java.util.*;
import java.io.*;

// 14427 : 수열과 쿼리 15

/**
 * Example
 * 5
 * 5 4 3 2 1
 * 5
 * 2
 * 1 5 3
 * 2
 * 1 4 3
 * 2
 */
public class Main {
    public static int height;
    public static int start;
    public static int[] tree;
    public static int[] value;
    public static int N;

    public static void init() {
        for (int i = height - 1; 0 <= i; i--) {
            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
                if (value[tree[j * 2]] > value[tree[j * 2 + 1]]) {
                    tree[j] = tree[j * 2 + 1];
                } else if (value[tree[j * 2]] < value[tree[j * 2 + 1]]) {
                    tree[j] = tree[j * 2];
                } else {
                    tree[j] = Math.min(tree[j * 2], tree[j * 2 + 1]);
                }
            }
        }
    }

    public static void update(int c, int v, int l, int r) {
        if (!(l <= v && v <= r)) {
            return;
        }

        if (l != r) {
            update(c * 2, v, l, (l + r) / 2);
            update(c * 2 + 1, v, (l + r) / 2 + 1, r);

            if (value[tree[c * 2]] > value[tree[c * 2 + 1]]) {
                tree[c] = tree[c * 2 + 1];
            } else if (value[tree[c * 2]] < value[tree[c * 2 + 1]]) {
                tree[c] = tree[c * 2];
            } else {
                tree[c] = Math.min(tree[c * 2], tree[c * 2 + 1]);
            }
        }
    }

    public static int search(int c, int l, int r, int sl, int sr) {
        if (l <= sl && sr <= r) {
            return tree[c];
        }

        if (r < sl || sr < l) {
            return N;
        }

        int a = search(c * 2, l, (l + r) / 2, sl, sr);
        int b = search(c * 2 + 1, (l + r) / 2 + 1, r, sl, sr);

        if (value[a] > value[b]) {
            return b;
        } else if (value[a] < value[b]){
            return a;
        } else {
            return Math.min(a, b);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14427_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        height = (int) Math.ceil(Math.log(N) / Math.log(2));
        start = (int) Math.pow(2, height);
        value = new int[start + 1];
        tree = new int[start * 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            tree[start + i] = i;
        }

        for (int i = N; i < start; i++) {
            value[i] = Integer.MAX_VALUE;
            tree[start + i] = i;
        }
        value[start] = Integer.MAX_VALUE;
        init();
//        print();

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                value[b - 1] = c;
                update(1, b, 1, start);
            } else {
                bw.write((search(1, 1, start, 1, start) + 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void print() {
        for (int i = 0; i <= height; i++) {
            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
                System.out.print(tree[j] + " ");
            }
            System.out.println();
        }
    }
}