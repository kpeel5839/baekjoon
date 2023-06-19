import java.util.*;
import java.io.*;

// 16953 : A -> B

/**
 * Example
 * 2 162
 */
public class Main {

    public static long A;
    public static long B;

    public static long bfs(long v) {
        Queue<long[]> q = new LinkedList<>();
        Set<Long> visited = new HashSet<>();
        q.add(new long[] {v, 0});

        while (!q.isEmpty()) {
            long[] point = q.poll();

            if (point[0] == B) {
                return point[1] + 1;
            }

            if (visited.contains(point[0])) {
                continue;
            }

            visited.add(point[0]);

            long newValue1 = point[0] * 2;
            long newValue2 = point[0] * 10 + 1;

            if (newValue1 <= B) {
                q.add(new long[] {newValue1, point[1] + 1});
            }

            if (newValue2 <= B) {
                q.add(new long[] {newValue2, point[1] + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16953_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        System.out.println(bfs(A));
    }
}