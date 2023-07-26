import java.util.*;
import java.io.*;

// 12761 : 돌다리

/**
 * Example
 * 2 3 1 20
 */
public class Main {
    public static final int MAX_SIZE = 100_000;
    public static boolean inRange(int index) {
        return 0 <= index && index <= MAX_SIZE;
    }

    public static List<Integer> moveResult(int index, int A, int B) {
        List<Integer> move = new ArrayList<>();

        move.add(index + 1);
        move.add(index - 1);
        move.add(index + A);
        move.add(index - A);
        move.add(index + B);
        move.add(index - B);
        move.add(index * A);
        move.add(index * B);

        return move;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_12761_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {N, 0});
        boolean[] visited = new boolean[MAX_SIZE + 1];
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == M) {
                System.out.println(p[1]);
                return;
            }

            moveResult(p[0], A, B).stream()
                    .filter(Main::inRange)
                    .filter(index -> !visited[index])
                    .forEach(index -> addQueue(q, visited, p, index));
        }
    }

    private static void addQueue(
            final Queue<int[]> q,
            final boolean[] visited,
            final int[] p,
            final Integer index
    ) {
        q.add(new int[] {index, p[1] + 1});
        visited[index] = true;
    }

}