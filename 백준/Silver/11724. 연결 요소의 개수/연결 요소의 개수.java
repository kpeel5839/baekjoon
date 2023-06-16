import java.util.*;
import java.io.*;

// 11724 : 연결 요소의 개수

/**
 * Example
 * 6 5
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 */
public class Main {

    public static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11724_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a = find(a);
            b = find(b);

            if (a != b) {
                union(a, b);
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        System.out.println(set.size());
    }
}