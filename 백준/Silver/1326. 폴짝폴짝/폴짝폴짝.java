import java.util.*;
import java.io.*;

// 1326 : 폴짝폴짝

/**
 * Example
 * 5
 * 1 2 2 1 2
 * 1 5
 */
public class Main {

    public static int N;

    public static boolean outOfRange(int index) {
        return index < 0 || N <= index;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1326_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()) - 1;
        int B = Integer.parseInt(st.nextToken()) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        visited[A] = true;
        q.add(new int[] {A, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int mul = 1;

            if (p[0] == B) {
                System.out.println(p[1]);
                return;
            }

            while (!outOfRange(p[0] + mul * arr[p[0]])) {
                q.add(new int[] {p[0] + mul * arr[p[0]], p[1] + 1});
                visited[p[0] + mul * arr[p[0]]] = true;
                mul++;
            }

            mul = 1;

            while (!outOfRange(p[0] - mul * arr[p[0]])) {
                q.add(new int[] {p[0] - mul * arr[p[0]], p[1] + 1});
                visited[p[0] - mul * arr[p[0]]] = true;
                mul++;
            }
        }

        System.out.println(-1);
    }
}
