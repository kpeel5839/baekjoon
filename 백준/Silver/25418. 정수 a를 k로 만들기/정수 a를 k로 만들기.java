import java.util.*;
import java.io.*;
import java.util.function.Function;

// 25418 : 정수 a 를 k 로 만들기

/**
 * Example
 * 5 10
 */
public class Main {

    public static List<Function<Integer, Integer>> operation = List.of(v -> v + 1, v -> v * 2);

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_25418_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[B + 1];
        q.add(new int[] {A, 0});
        visited[A] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == B) {
                System.out.println(p[1]);
                return;
            }

            for (Function<Integer, Integer> f : operation) {
                int next = f.apply(p[0]);

                if (B < next || visited[next]) {
                    continue;
                }

                q.add(new int[] {next, p[1] + 1});
                visited[next] = true;
            }
        }
    }
}