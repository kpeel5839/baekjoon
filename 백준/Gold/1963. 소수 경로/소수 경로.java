import java.util.*;
import java.io.*;

// 1963 : 소수 경로

/**
 * Example
 * 3
 * 1033 8179
 * 1373 8017
 * 1033 1033
 */
public class Main {

    public static boolean[] isNotPrime = new boolean[10001];

    public static void setPrime() {
        for (int i = 2; i <= 100; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * 2; j <= 10000; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1963_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        setPrime();

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        Loop:
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            boolean[] visited = new boolean[10001];
            visited[a] = true;
            q.add(new int[] {a, 0});

            while (!q.isEmpty()) {
                int[] p = q.poll();

                if (p[0] == b) {
                    sb.append(p[1]).append("\n");
                    continue Loop;
                }

                for (int i = 1; i <= 1000; i *= 10) {
                    int standard = p[0] - (((p[0] % (i * 10)) / i) * i);

                    for (int j = 0; j <= 9; j++) {
                        int now = standard + (j * i);

                        if (now < 1000 || isNotPrime[now] || visited[now]) {
                            continue;
                        }

                        q.add(new int[] {now, p[1] + 1});
                        visited[now] = true;
                    }
                }
            }

            sb.append(0).append("\n");
        }

        System.out.println(sb);
    }
}