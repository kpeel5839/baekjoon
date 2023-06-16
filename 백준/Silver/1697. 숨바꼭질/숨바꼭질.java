import java.util.*;
import java.io.*;
import java.util.function.Function;

// 1697 : 숨바꼭질

/**
 * Example
 * 5 17
 */
public class Main {

    public static int N;
    public static int M;

    public static boolean outOfRange(int x) {
        return x < 0 || 300_000 < x;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1697_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Function<Integer, Integer>> operation = Map.of(
                0, v -> v + 1,
                1, v -> v - 1,
                2, v -> v * 2
        );

        q.add(new int[] {N, 0});
        visited.add(N);

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == M) {
                System.out.println(point[1]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int newPosition = operation.get(i).apply(point[0]);

                if (outOfRange(newPosition) || visited.contains(newPosition)) {
                    continue;
                }

                q.add(new int[] {newPosition, point[1] + 1});
                visited.add(newPosition);
            }
        }
    }
}