import java.util.*;
import java.io.*;

// 2104 : 부분 배열 고르기

/**
 * Example
 * 6
 * 3 1 6 4 5 2
 */
public class Main {
    public static int N;
    public static int height;
    public static int[] tree;
    public static long[] sum;
    public static long[] value;
    public static long ans = 0;

    public static void init() {
        for (int i = height - 1; 0 <= i; i--) {
            for (int j = (int) Math.pow(2, i); j < (int) Math.pow(2, i + 1); j++) {
                if (value[tree[j * 2]] > value[tree[j * 2 + 1]]) {
                    tree[j] = tree[j * 2 + 1];
                } else {
                    tree[j] = tree[j * 2];
                }
            }
        }
    }

    public static int search(int c, int l, int r, int sl, int sr) {
        if (r < sl || sr < l) {
            return (int) Math.pow(2, height);
        }

        if (sl <= l && r <= sr) {
            return tree[c];
        }

        int a = search(c * 2, l, (l + r) / 2, sl, sr);
        int b = search(c * 2 + 1, (l + r) / 2 + 1, r, sl, sr);

        if (value[a] > value[b]) {
            return b;
        } else {
            return a;
        }
    }

    public static void re(int l, int r) {
        if (r < l) {
            return;
        }

        int a = search(1, 1, (int) Math.pow(2, height), l + 1, r + 1);
        ans = Math.max(ans, (long) (sum[r] - (l != 0 ? sum[l - 1] : 0)) * value[a]);

        re(l, a - 1);
        re(a + 1, r);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2104_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        height = (int) Math.ceil(Math.log(N) / Math.log(2));
        value = new long[(int) Math.pow(2, height) + 1];
        sum = new long[(int) Math.pow(2, height) + 1];
        tree = new int[(int) Math.pow(2, height) * 2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            tree[(int) Math.pow(2, height) + i] = i;
            sum[i] = value[i] + (i != 0 ? sum[i - 1] : 0);
        }

        for (int i = N; i < (int) Math.pow(2, height); i++) {
            value[i] = Integer.MAX_VALUE;
            tree[(int) Math.pow(2, height) + i] = i;
            sum[i] = Integer.MAX_VALUE;
        }

        value[(int) Math.pow(2, height)] = Integer.MAX_VALUE;
        sum[(int) Math.pow(2, height)] = Integer.MAX_VALUE;

        init();
        re(0, N - 1);

        System.out.println(ans);
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