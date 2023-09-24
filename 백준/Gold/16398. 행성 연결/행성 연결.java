import java.util.*;
import java.io.*;

// 16398 : 행성 연결

/**
 * Example
 * 5
 * 0 6 8 1 3
 * 6 0 5 7 3
 * 8 5 0 9 4
 * 1 7 9 0 6
 * 3 3 4 6 0
 */
public class Main {
    public static int[] p;
    public static int find(int x) {
        if (p[x] == x) {
            return x;
        }

        return p[x] = find(p[x]);
    }
    public static void union(int a, int b) {
        p[b] = a;
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16398_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        p = new int[N];
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = i;

            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());

                if (i + 1 <= j) {
                    list.add(new int[] {i, j, value});
                }
            }

        }

        Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);

        for (int[] next : list) {
            int a = find(next[0]);
            int b = find(next[1]);

            if (a != b) {
                union(a, b);
                ans += next[2];
            }
        }
        
        System.out.println(ans);
    }
}