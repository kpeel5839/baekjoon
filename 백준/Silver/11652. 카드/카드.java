import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

// 11652 : 카드

/**
 * Example
 * 5
 * 1
 * 2
 * 1
 * 2
 * 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_11652_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Long, Integer> m = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long l = Long.parseLong(br.readLine());

            m.put(l, m.getOrDefault(l, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> entries = new ArrayList<>(m.entrySet());
        entries.sort((o1, o2) -> Long.compare(o1.getKey(), o2.getKey()));

        Integer max = Integer.MIN_VALUE;
        Long ans = 0L;
        for (Map.Entry<Long, Integer> entry : entries) {
            if (max < entry.getValue()) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }

        System.out.println(ans);
    }
}