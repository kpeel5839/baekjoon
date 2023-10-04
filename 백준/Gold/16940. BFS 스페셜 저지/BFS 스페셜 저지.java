import java.util.*;
import java.io.*;

// 16940 : BFS 스페셜 저지

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
    public static int[] visitedSequence;
    public static List<Set<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16940_problem/src/input.txt"));
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

        int index = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int p = q.poll();

            for (int i = 0; i < (p == 1 ? graph.get(p).size() : graph.get(p).size() - 1); i++) {
                q.add(visitedSequence[index]);

                if (!graph.get(p).contains(visitedSequence[index])) {
                    System.out.println(0);
                    return;
                }

                index++;
            }
        }

        System.out.println(1);
    }
}