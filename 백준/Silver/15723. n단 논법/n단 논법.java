import java.util.*;
import java.io.*;

// 15723 : n단 논법

/**
 * Example
 * 3
 * a is b
 * b is c
 * c is d
 * 3
 * a is d
 * a is c
 * d is a
 */
public class Main {
    public static boolean[] visited;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static void bfs(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        visited[a] = true;
        q.add(a);

        while (!q.isEmpty()) {
            int p = q.poll();

            if (p == b) {
                System.out.println("T");
                return;
            }

            for (Integer next : graph.get(p)) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        System.out.println("F");
    }
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_15723_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int a = s[0].charAt(0) - 'a';
            int b = s[2].charAt(0) - 'a';

            graph.get(a).add(b);
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            visited = new boolean[26];
            int a = s[0].charAt(0) - 'a';
            int b = s[2].charAt(0) - 'a';
            bfs(a, b);
        }
    }
}