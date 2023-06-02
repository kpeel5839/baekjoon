import java.util.*;
import java.io.*;

// 20551 : Sort 마스터 배지훈의 후계자

/**
 * Example
 * 5 5
 * 9
 * 0
 * -1
 * 3
 * 2
 * -1
 * 10
 * 5
 * 9
 * 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_20551_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (!m.containsKey(arr[i])) {
                m.put(arr[i], i);
            }
        }

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(br.readLine());

            if (m.containsKey(number)) {
                bw.write(m.get(number) + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}