import java.util.*;
import java.io.*;

// 5568 : 카드 놓기

/**
 * Example
 * 4
 * 2
 * 1
 * 2
 * 12
 * 1
 */
public class Main {
    public static String[] arr;
    public static Set<String> set = new HashSet<>();
    public static boolean[] v;
    public static int K;

    public static void dfs(int index, int k, String s) {
        v[index] = true;

        if (K <= k) {
//            System.out.println(k + " " + s);
            set.add(s);
        } else {
//            System.out.println(k + " " + s);
            for (int i = 0; i < arr.length; i++) {
                if (!v[i]) {
                    dfs(i, k + 1, s + arr[i]);
                }
            }
        }

        v[index] = false;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_5568_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new String[N];
        v = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1, arr[i]);
        }

        System.out.println(set.size());
    }
}