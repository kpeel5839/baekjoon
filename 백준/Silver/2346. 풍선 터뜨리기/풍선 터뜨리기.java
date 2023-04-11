import java.util.*;
import java.io.*;

// 2346 : 풍선 터뜨리기

/**
 * Example
 * 5
 * 3 2 1 -3 -1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_2346_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        List<Integer> l = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            l.add(i);
        }

        int remove = 0;
        for (int i = 0; i < N - 1; i++) {
            Integer v = l.remove(remove);

            if (arr[v] < 0) {
                int i1 = arr[v] * -1;
                remove = (remove - (i1 % l.size()) + l.size()) % l.size();
            } else {
                remove = (remove + (arr[v] - 1)) % l.size();
            }

            bw.write(v + " ");
        }

        bw.write(l.get(remove) + " ");
        bw.flush();
        bw.close();
    }
}