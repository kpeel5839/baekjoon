import java.util.*;
import java.io.*;

// 24041 : 성싶당 밀키트 

/**
 * Example
 * 4 36 0
 * 2 14 1
 * 3 8 1
 * 5 12 1
 * 7 10 0
 */
public class Main {

    public static long N;
    public static long G;
    public static long K;
    public static long[][] value;

    public static boolean isPossible(long day) {
        PriorityQueue<Long> q = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
        long totalGerm = 0;

        for (int i = 0; i < N; i++) {
            long germ = value[i][0] * Math.max(1, day - value[i][1]);
            totalGerm += germ;

            if (value[i][2] == 1) {
                q.add(germ);
            }
        }

        long count = 0;

        while (!q.isEmpty() && count < K) {
            totalGerm -= q.poll();
            count++;
        }

        return totalGerm <= G;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_24041_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        G = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        value = new long[(int) N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            value[i][0] = Long.parseLong(st.nextToken());
            value[i][1] = Long.parseLong(st.nextToken());
            value[i][2] = Long.parseLong(st.nextToken());
        }

        long left = 1;
        long right = 2_000_000_000L;
        long ans = 0;

        while (left <= right) {
            long day = (left + right) / 2;

            if (isPossible(day)) {
                left = day + 1;
                ans = day;
            } else {
                right = day - 1;
            }
        }

        System.out.println(ans);
    }
}