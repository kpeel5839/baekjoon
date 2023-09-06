import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2668 : 숫자고르기

/**
 * Example
 * 7
 * 3
 * 1
 * 1
 * 5
 * 5
 * 4
 * 6
 */
public class Main {

    public static int groupNumber = 1;
    public static int N;
    public static int[] visited;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static List<Integer> ans = new ArrayList<>();
    public static List<Integer> group;

    public static void dfs(int index) {
        visited[index] = groupNumber;
        group.add(index);
        int next = graph.get(index).get(0);

        if (visited[next] != 0) {
            if (visited[next] == groupNumber && group.contains(next)) {
                for (int i = 0; i < group.size(); i++) {
                    int value = group.get(i);

                    if (value == next) {
                        ans.addAll(group.subList(i, group.size()));
                        break;
                    }
                }
            }

            return;
        }

        dfs(next);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2668_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(br.readLine());
            graph.get(i).add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                group = new ArrayList<>();
                dfs(i);
                groupNumber++;
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(ans);

        sb.append(ans.size()).append("\n");
        ans.forEach(v -> sb.append(v).append("\n"));
        System.out.println(sb);
    }
}