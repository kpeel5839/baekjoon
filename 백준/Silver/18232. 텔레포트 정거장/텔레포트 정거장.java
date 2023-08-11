import java.util.*;
import java.io.*;
import java.util.function.Function;

// 18232 : 텔레포트 정거장

/**
 * Example
 * 5 1
 * 1 5
 * 1 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
       //  System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_18232_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        List<Integer>[] tele = new List[N + 1];

        for (int i = 0; i < tele.length; i++) {
            tele[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tele[a].add(b);
            tele[b].add(a);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == E) {
                System.out.println(p[1]);
                return;
            }

            for (int i = -1; i <= 1; i += 2) {
                int np = p[0] + i;

                if (np < 0 || N < np || visited[np]) {
                    continue;
                }

                q.add(new int[] {np, p[1] + 1});
                visited[np] = true;
            }

            for (Integer next : tele[p[0]]) {
                if (!visited[next]) {
                    q.add(new int[] {next, p[1] + 1});
                    visited[next] = true;
                }
            }
        }
    }
}