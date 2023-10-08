import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

// 13418 : 학교 탐방하기

/**
 * Example
 * 4 5
 * 0 1 1
 * 1 2 0
 * 1 4 0
 * 4 2 1
 * 3 4 1
 * 2 3 0
 */
public class Main {

    public static int N;
    public static int M;
    public static List<int[]> edges = new ArrayList<>();
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

    public static int shortestPath(BiFunction<int[], int[], Integer> function) {
        edges.sort(function::apply);
        parent = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int a = find(edge[0]);
            int b = find(edge[1]);

            if (a != b) {
                union(a, b);

                if (edge[2] == 0) {
                    count++;
                }
            }
        }

        return square(count);
    }

    public static int square(int number) {
        return (int) Math.pow(number, 2);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13418_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken()) + 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[] {a, b, c});
        }

        System.out.println(shortestPath((o1, o2) -> o1[2] - o2[2]) - shortestPath((o1, o2) -> o2[2] - o1[2]));
    }
}