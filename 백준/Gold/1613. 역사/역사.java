import java.util.*;
import java.io.*;

// 1613 : 역사

/**
 * Example
 * 5 5
 * 1 2
 * 1 3
 * 2 3
 * 3 4
 * 2 4
 * 3
 * 1 5
 * 2 4
 * 3 1
 */
public class Main {
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1613_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] entry = new int[N + 1];
        int[] visit = new int[N + 1];
        Map<Integer, Set<Integer>> m = new HashMap<>();
        Arrays.fill(visit, -1);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            m.put(i, new HashSet<>());
            m.get(i).add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            entry[b]++;
            graph.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            if (entry[i] == 0) {
                q.add(new int[] {i, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            visit[p[0]] = p[1];

            for (Integer next : graph.get(p[0])) {
                m.get(next).addAll(m.get(p[0]));
                if (--entry[next] == 0) {
                    q.add(new int[] {next, p[1] + 1});
                }
            }
        }

        int S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean swap = false;

            if (visit[b] < visit[a]) {
                int tmp = a;
                a = b;
                b = tmp;
                swap = true;
            }

            if (visit[a] == visit[b] || !m.get(b).contains(a)) {
                sb.append(0).append("\n");
            } else {
                sb.append(swap ? 1 : -1).append("\n");
            }
        }

        System.out.println(sb);
    }
}