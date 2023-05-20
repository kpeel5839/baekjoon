import java.util.*;
import java.io.*;

// 20301 : 반전 요세푸스 순열

/**
 * Example
 * 7 3 4
 */
public class Main {

    public static int N;
    public static int K;
    public static int M;

    public static int nextRemove(int index, int size, boolean right) {
        if (size == 0) {
            return -1;
        }

        if (right) {
            return (index + (K - 1)) % size;
        }

        return ((index + size * (int) Math.ceil((double) K / size)) - K) % size;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_20301_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        boolean right = true;
        int index = K - 1;

        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        for (int i = 1; i <= N; i++) {
            if (i % M == 0) {
                right = !right;
            }

            Integer remove = arr.remove(index);
            index = nextRemove(index, arr.size(), right);
            bw.write(remove + "\n");
        }

        bw.flush();
        bw.close();
    }
}