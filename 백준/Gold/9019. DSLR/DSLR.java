import java.util.*;
import java.io.*;
import java.util.function.Function;

// 9019 : DSLR

/**
 * Example
 * 3
 * 1234 3412
 * 1000 1
 * 1 16
 */
public class Main {
    public static char[] mapper = new char[] {'D', 'S', 'L', 'R'};
    public static List<Function<Integer, Integer>> operation = List.of(
            v -> (v * 2) % 10000,
            v -> (v - 1 + 10000) % 10000,
            v -> (v * 10 % 10000) + v / 1000,
            v -> ((v % 10) * 1000) + (v / 10)
    );
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9019_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[10001];
            Queue<Object[]> q = new LinkedList<>();
            q.add(new Object[] {a, ""});
            visited[a] = true;

            while (!q.isEmpty()) {
                Object[] p = q.poll();

                if (p[0].equals(b)) {
                    bw.write(p[1] + "\n");
                    break;
                }

                for (int i = 0; i < operation.size(); i++) {
                    int np = operation.get(i).apply((int) p[0]);

                    if (visited[np]) {
                        continue;
                    }

                    q.add(new Object[] {np, (String)p[1] + mapper[i]});
                    visited[np] = true;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}