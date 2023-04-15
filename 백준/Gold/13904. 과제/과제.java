import java.util.*;
import java.io.*;

// 13904 : 과제

/**
 * Example
 * 7
 * 4 60
 * 4 40
 * 1 20
 * 2 50
 * 3 30
 * 4 10
 * 6 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_13904_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer>[] qq = new PriorityQueue[1001];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < qq.length; i++) {
            qq[i] = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            qq[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;

        for (int i = 1; i < qq.length; i++) {
            if (qq[i].isEmpty()) {
                continue;
            }
            
            while (q.size() < i && !qq[i].isEmpty()) {
                Integer poll = qq[i].poll();
                q.add(poll);
                ans += poll;
            }
            
            while (!q.isEmpty() && !qq[i].isEmpty()) {
                if (q.peek() < qq[i].peek()) {
                    Integer poll = q.poll();
                    ans -= poll;
                    Integer poll1 = qq[i].poll();
                    q.add(poll1);
                    ans += poll1;
                } else {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}