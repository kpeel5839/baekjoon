import java.util.*;
import java.io.*;
import java.util.function.IntPredicate;
import javax.swing.LookAndFeel;

// 11158 : The Game Of Death

/**
 * Example
 * 1
 * 7
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11158_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Loop:
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] choice = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                choice[i] = Integer.parseInt(br.readLine());
            }

            Queue<int[]> q = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            visited[1] = true;
            q.add(new int[] {1, 0});

            while (!q.isEmpty()) {
                int[] p = q.poll();

                if (p[0] == N) {
                    System.out.println(p[1]);
                    continue Loop;
                }

                if (visited[choice[p[0]]]) {
                    continue;
                }

                q.add(new int[] {choice[p[0]], p[1] + 1});
                visited[choice[p[0]]] = true;
            }

            System.out.println(0);
        }
    }
}