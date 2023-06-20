import java.util.*;
import java.io.*;

// 18352 : 특정 거리의 도시 찾기

/**
 * Example
 * 4 4 2 1
 * 1 2
 * 1 3
 * 2 3
 * 2 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_18352_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {X, 0});
        visited[X] = true;
        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[1] == K) {
                list.add(point[0]);
            }

            for (Integer next : graph.get(point[0])) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[] {next, point[1] + 1});
                }
            }
        }

        if (list.isEmpty()){
            bw.write(-1 + "\n");
        }

        Collections.sort(list);

        for (Integer next : list) {
            bw.write(next + "\n");
        }

        bw.flush();
        bw.close();
    }
}