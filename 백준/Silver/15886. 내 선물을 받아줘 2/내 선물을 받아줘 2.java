import java.util.*;
import java.io.*;

// 11158 : 내 선물을 받아줘 2

/**
 * Example
 * 6
 * EEWWEW
 */
public class Main {
    public static int[] parent;

    public static Map<Character, Integer> direction = Map.of(
            'E', 1,
            'W', -1
    );

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
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15886_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] map = br.readLine().toCharArray();
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            int a = find(i);
            int b = find(i + direction.get(map[i]));

            if (a != b) {
                union(a, b);
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(find(parent[i]));
        }

        System.out.println(set.size());
    }
}