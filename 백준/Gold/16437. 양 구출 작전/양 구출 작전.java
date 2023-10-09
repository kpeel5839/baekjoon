import java.util.*;
import java.io.*;

// 16437 : 양 구출 작전

/**
 * Example
 * 4
 * S 100 3
 * W 50 1
 * S 10 1
 */
public class Main {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static int[] animalCount;
    public static boolean[] isWolf;

    public static long dfs(int parent, int current) {
        long result = 0;

        for (Integer next : graph.get(current)) {
            if (parent != next) {
                result += dfs(current, next);
            }
        }

        result += isWolf[current] ? -animalCount[current] : animalCount[current];
        return Math.max(0, result);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16437_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        animalCount = new int[N + 1];
        isWolf = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            char a = st.nextToken().charAt(0);
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 'W') {
                isWolf[i] = true;
            }

            animalCount[i] = b;
            graph.get(c).add(i);
        }

        System.out.println(dfs(-1, 1));
    }
}