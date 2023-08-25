import java.util.*;
import java.io.*;

// 13700 : 완전 범죄

/**
 * Example
 * 20 1 20 2 1 4
 * 5 10 15 19
 */
public class Main {
    public static int N;
    public static int S;
    public static int D;
    public static int[] move = new int[2];
    public static Set<Integer> police = new HashSet<>();
    public static String BUG = "BUG FOUND";

    public static boolean outOfRange(int index) {
        return index < 0 || N < index;
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(new int[] {S, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == D) {
                return p[1];
            }

            for (int i = 0; i < 2; i++) {
                int newIndex = p[0] + move[i];

                if (outOfRange(newIndex) || visited[newIndex] || police.contains(newIndex)) {
                    continue;
                }

                q.add(new int[] {newIndex, p[1] + 1});
                visited[newIndex] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13700_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        move[0] = Integer.parseInt(st.nextToken());
        move[1] = -Integer.parseInt(st.nextToken());
        int policeCount = Integer.parseInt(st.nextToken());

        if (policeCount != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < policeCount; i++) {
                police.add(Integer.parseInt(st.nextToken()));
            }
        }

        int result = bfs();

        if (result == -1) {
            System.out.println(BUG);
        } else {
            System.out.println(result);
        }
    }
}