import java.util.*;
import java.io.*;

// 21316 : 스피카

/**
 * Example
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 3 7
 * 4 9
 * 6 7
 * 7 8
 * 9 8
 * 9 10
 * 10 11
 * 12 11
 */
public class Main {

    public static List<List<Integer>> list = new ArrayList<>();

    public static boolean bfs(int start) {
        boolean[] visited = new boolean[12 + 1];
        int max = 0;
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int count = 0;
            max = Math.max(max, p[1]);

            for (Integer next : list.get(p[0])) {
                if (!visited[next]) {
                    count++;
                    q.add(new int[] {next, p[1] + 1});
                    visited[next] = true;
                }
            }

            if (count == 0) {
                set.add(p[1]);
            }
        }

        return max == 5 && set.contains(1);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_21316_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i <= 12; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < 12; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= 12; i++) {
            if (list.get(i).size() == 3) {
                if (bfs(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}