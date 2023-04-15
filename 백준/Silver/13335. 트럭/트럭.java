import java.util.*;
import java.io.*;

// 13335 : 트럭

/**
 * Example
 * 4 2 10
 * 7 4 5 6
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13335_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<int[]> d = new LinkedList<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int time = 1;
        int weight = 0;

        for (int i = 0; i < N; i++) {
            while (!d.isEmpty()) {
                if (W < weight + arr[i]) {
                    int[] v = d.pollLast();
                    time += L - (time - v[0]);
                    weight -= v[1];
                    continue;
                }

                if (L <= time - d.peekLast()[0]) {
                    weight -= d.pollLast()[1];
                }

                break;
            }

            d.addFirst(new int[] {time, arr[i]});
            weight += arr[i];
            time++;
        }

        if (!d.isEmpty()) {
            time += L - (time - d.pollFirst()[0]);
        }

        System.out.println(time);
    }
}