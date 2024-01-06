import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 15678 : 연세워터파크

/**
 * Example
 * 10 2
 * 2 7 -5 -4 10 -5 -5 -5 30 -10
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_15678_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        PriorityQueue<long[]> q = new PriorityQueue<>((o1, o2) -> Long.compare(o2[1], o1[1])); // {index, value}

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = arr[n - 1];
        q.add(new long[] {n - 1, answer});
        for (int i = n - 2; 0 <= i; i--) {
            while (d < q.peek()[0] - i) {
                q.poll();
            }

            long[] value = q.peek();
            long nowValue = Math.max(arr[i], arr[i] + value[1]);
            answer = Math.max(answer, nowValue);
            q.add(new long[] {i, nowValue});
        }

        System.out.println(answer);
    }

}