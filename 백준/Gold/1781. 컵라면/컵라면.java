import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// 1781 : 컵라면

/**
 * Example
 * 7
 * 1 6
 * 1 7
 * 3 2
 * 3 1
 * 2 4
 * 2 5
 * 6 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1781_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, PriorityQueue<Integer>> m = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (!m.containsKey(key)) {
                m.put(key, new PriorityQueue<>((o1, o2) -> o2 - o1));
            }

            m.get(key).add(value);
        }

        List<Map.Entry<Integer, PriorityQueue<Integer>>> collect = m.entrySet()
                .stream()
                .sorted((o1, o2) -> o1.getKey() - o2.getKey())
                .collect(Collectors.toList());

        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : collect) {
            Integer key = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();

            while (!value.isEmpty() && q.size() < key) {
                Integer poll = value.poll();
                q.add(poll);
                ans += poll;
            }

            while (!q.isEmpty() && !value.isEmpty() && q.peek() < value.peek()) {
                Integer poll = q.poll();
                ans -= poll;
                Integer poll1 = value.poll();
                ans += poll1;
                q.add(poll1);
            }
        }

        System.out.println(ans);
    }
}