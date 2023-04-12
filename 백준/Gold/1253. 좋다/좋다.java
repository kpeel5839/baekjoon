import java.util.*;
import java.io.*;

// 1253 : 좋다

/**
 * Example
 * 10
 * 1 2 3 4 5 6 7 8 9 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1253_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }

                int a = arr[i];
                int b = arr[j];
                int c = a - b;

                if (!m.containsKey(c)) {
                    continue;
                }

                Map<Integer, Integer> mm = new HashMap<>();
                mm.put(a, m.get(a));
                mm.put(b, m.get(b));
                mm.put(c, m.get(c));

                mm.put(a, mm.get(a) - 1);
                mm.put(b, mm.get(b) - 1);
                mm.put(c, mm.get(c) - 1);

                boolean fail = false;
                for (Integer next : mm.values()) {
                    if (next < 0) {
                        fail = true;
                    }
                }

                if (!fail) {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}