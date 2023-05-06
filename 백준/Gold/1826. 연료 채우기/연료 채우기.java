import java.util.*;
import java.io.*;

// 1826 : 연료 채우기

/**
 * Example
 * 4
 * 4 4
 * 5 2
 * 11 5
 * 15 10
 * 25 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1826_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] r = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            r[i][0] = Integer.parseInt(st.nextToken());
            r[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int G = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Arrays.sort(r, (o1, o2) -> o1[0] - o2[0]);
        int index = 0;
        int ans = 0;

        while (L < G) {
            if (!q.isEmpty()) {
                L += q.poll();
                ans++;
            }

            while (index < r.length && r[index][0] <= L) {
                q.add(r[index++][1]);
            }

            if (q.isEmpty()) {
                break;
            }
        }

        System.out.println(L < G ? -1 : ans);
    }
}
