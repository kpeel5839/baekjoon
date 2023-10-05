import java.util.*;
import java.io.*;

// 16964 : DFS 스페셜 저지

/**
 * Example
 * 4
 * 1 2
 * 1 3
 * 2 4
 * 1 2 3 4
 */
public class Main {

    public static int N;
    public static int index = 1;
    public static int[] visitedSequence;
    public static boolean result = true;
    public static List<Set<Integer>> graph = new ArrayList<>();

    public static void dfs(int parent, int current) {
        int childSize = current == 1 ? graph.get(current).size() : graph.get(current).size() - 1;

        for (int i = 0; i < childSize; i++) {
            if (index != N && parent != visitedSequence[index]) {
                if (!graph.get(current).contains(visitedSequence[index])) {
                    result = false;
                    return;
                }

                dfs(current, visitedSequence[index++]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16964_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visitedSequence = new int[N];

        for (int i = 0; i <= N; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitedSequence[i] = Integer.parseInt(st.nextToken());
        }

        if (visitedSequence[0] != 1) {
            System.out.println(0);
            return;
        }

        dfs(-1, 1);

        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}