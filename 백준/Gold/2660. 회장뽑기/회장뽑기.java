import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// 2660 : 회장뽑기

/**
 * Example
 * 5
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 2 4
 * 5 3
 * -1 -1
 */
public class Main {

    public static int N;
    public static boolean[] visited;
    public static List<List<Integer>> list = new ArrayList<>();

    public static class Group implements Comparable<Group> {

        int number;
        int score;

        public Group(int number, int score) {
            this.number = number;
            this.score = score;
        }

        @Override
        public int compareTo(Group g) {
            if (this.score == g.score) {
                return this.number - g.number;
            }

            return this.score - g.score;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "number=" + number +
                    ", score=" + score +
                    '}';
        }

    }

    public static Group bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N + 1];
        q.add(new int[] {start, 0});
        visited[start] = true;
        int score = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            score = Math.max(score, p[1]);

            for (Integer next : list.get(p[0])) {
                if (!visited[next]) {
                    q.add(new int[] {next, p[1] + 1});
                    visited[next] = true;
                }
            }
        }

        return new Group(start, score);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2660_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            list.get(a).add(b);
            list.get(b).add(a);
        }

        List<Group> groups = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            groups.add(bfs(i));
        }

        Collections.sort(groups);
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).score == groups.get(0).score) {
                ans.add(groups.get(i).number);
            }
        }

        sb.append(groups.get(0).score + " " + ans.size()).append("\n");
        ans.forEach(v -> sb.append(v).append(" "));
        System.out.println(sb);
    }
}