import java.util.*;
import java.io.*;

// 17503 : 맥주 축제

/**
 * Example
 * 3 9 5
 * 2 5
 * 4 6
 * 3 3
 * 4 3
 * 1 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17503_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] mac = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            mac[i][0] = Integer.parseInt(st.nextToken()); // like
            mac[i][1] = Integer.parseInt(st.nextToken()); // level
        }

        Arrays.sort(mac, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
        long nowM = 0;

        for (int i = 0; i < K; i++) {
            if (q.size() <= N) {
                q.add(mac[i][0]);
                nowM += mac[i][0];
            }

            if (N < q.size()) {
                nowM -= q.poll();
            }

            if (q.size() == N && M <= nowM) {
                System.out.println(mac[i][1] + "\n");
                return;
            }
        }

        System.out.println(-1);
    }
}