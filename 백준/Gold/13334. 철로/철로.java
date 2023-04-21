import java.util.*;
import java.io.*;

// 13334 : 철로

/**
 * Example
 * 8
 * 5 40
 * 35 25
 * 10 20
 * 10 25
 * 30 50
 * 50 60
 * 30 25
 * 80 100
 * 30
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13334_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = Math.min(a, b);
            arr[i][1] = Math.max(a, b);
        }

        List<int[]> l = new ArrayList<>();
        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (arr[i][1] - arr[i][0] <= L) {
                l.add(arr[i]);
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        l.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int ans = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < l.size(); i++) {
            max = Math.max(max, l.get(i)[1]);
            while (!q.isEmpty() && L < max - q.peek()) {
                q.poll();
            }

            q.add(l.get(i)[0]);
            ans = Math.max(ans, q.size());
        }

        System.out.println(ans);
    }
}