import java.util.*;
import java.io.*;

// 23350 : K 물류창고

/**
 * Example
 * 3 1
 * 1 2
 * 1 1
 * 1 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_23350_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int pri = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (!m.containsKey(pri)) {
                m.put(pri, 0);
                pq.add(pri);
            }

            m.put(pri, m.get(pri) + 1);
            q.add(new int[] {pri, weight});
        }

        int ans = 0;
        Stack<int[]> container = new Stack<>();

        while (!q.isEmpty()) {
            int[] p = q.peek();
            int pri = pq.peek();

            if (pri != p[0]) {
                q.add(q.poll());
                ans += p[1];
                continue;
            }

            Stack<int[]> stack = new Stack<>();

            while (!container.isEmpty() && container.peek()[1] < p[1] && container.peek()[0] == pri) {
                int[] pp = container.pop();
                ans += pp[1];
                stack.add(pp);
            }

            stack.add(new int[] {p[0], p[1]});
            m.put(pri, m.get(pri) - 1);

            if (m.get(pri) == 0) {
                pq.poll();
            }

            while (!stack.isEmpty()) {
                int[] pp = stack.pop();
                ans += pp[1];
                container.add(pp);
            }

            q.poll();
        }

        System.out.println(ans);
    }
}