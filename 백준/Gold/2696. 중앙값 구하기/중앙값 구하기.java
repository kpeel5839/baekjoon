import java.util.*;
import java.io.*;

// 2696 : 중앙값 구하기

/**
 * Example
 * 3
 * 9
 * 1 2 3 4 5 6 7 8 9
 * 9
 * 9 8 7 6 5 4 3 2 1
 * 23
 * 23 41 13 22 -3 24 -31 -11 -8 -7
 * 3 5 103 211 -311 -45 -67 -73 -81 -99
 * -33 24 56
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2696_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int row = (int) Math.ceil((double) N / 10);
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < (((i + 1) * 10 <= N) ? 10 : N % 10); j++) {
                    int v = Integer.parseInt(st.nextToken());

                    if (min.size() == max.size()) { // min 에 들어가야할 차례
                        max.add(v);
                    } else { // max 에 들어갈 차례
                        min.add(v);
                    }

                    if (!min.isEmpty() && !max.isEmpty() && min.peek() < max.peek()) {
                        Integer minV = min.poll();
                        Integer maxV = max.poll();
                        max.add(minV);
                        min.add(maxV);
                    }

                    if (j % 2 == 0) {
                        ans.add(max.peek());
                    }
                }
            }

            bw.write(ans.size() + "\n");
            for (int i = 1; i <= ans.size(); i++) {
                bw.write(ans.get(i - 1) + " ");

                if (i % 10 == 0 && i != ans.size()) {
                    bw.write("\n");
                }
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}