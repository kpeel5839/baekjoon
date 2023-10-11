import java.util.*;
import java.io.*;

// 16397 : 탈출

/**
 * Example
 * 1 7 10
 */
public class Main {

    public static int S;
    public static int T;
    public static int G;
    public static boolean[] visited = new boolean[100_001];

    public static int[] getNumber(int number) {
        int a = number + 1;
        int b = number * 2;

        if (100_000 <= a) {
            a = Integer.MAX_VALUE;
        }

        if (b == 0 || 100_000 <= b) {
            b = Integer.MAX_VALUE;
        }

        if (b != Integer.MAX_VALUE) {
            for (int i = 10_000; 1 <= i; i /= 10) {
                if (i <= b) {
                    b -= i;
                    break;
                }
            }
        }

        if (b == 0) {
            b = Integer.MAX_VALUE;
        }

        return new int [] {a, b};
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == G) {
                return p[1];
            }

            if (p[1] == T) {
                continue;
            }

            int[] next = getNumber(p[0]);

            for (int i = 0; i < next.length; i++) {
                if (next[i] == Integer.MAX_VALUE) {
                    continue;
                }

                if (visited[next[i]]) {
                    continue;
                }

                q.add(new int[] {next[i], p[1] + 1});
                visited[next[i]] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16397_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        int result = bfs();

        if (result == -1) {
            System.out.println("ANG");
        } else {
            System.out.println(result);
        }
    }
}