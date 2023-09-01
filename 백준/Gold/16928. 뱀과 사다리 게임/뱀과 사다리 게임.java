import java.util.*;
import java.io.*;

// 16928 : 뱀과 사다리 게임

/**
 * Example
 * 3 7
 * 32 62
 * 42 68
 * 12 98
 * 95 13
 * 97 25
 * 93 37
 * 79 27
 * 75 19
 * 49 47
 * 67 17
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16928_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.add(new int[] {1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] p =q.poll();

            if (p[0] == 100) {
                System.out.println(p[1]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int newIndex = p[0] + i;
                newIndex = ladder.getOrDefault(newIndex, newIndex);
                newIndex = snake.getOrDefault(newIndex, newIndex);

                if (newIndex < 1 || 100 < newIndex || visited[newIndex]) {
                    continue;
                }

                q.add(new int[] {newIndex, p[1] + 1});
                visited[newIndex] = true;
            }
        }
    }
}