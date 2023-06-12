import java.util.*;
import java.io.*;

// 12873 : 기념품

/**
 * Example
 * 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_12873_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        int index = 0;

        for (int i = 1; i < N; i++) {
            long move = (long) Math.pow(i, 3) - 1;

            index = (int) (((long) index + move) % (long) arr.size());
            arr.remove(index);
        }

        System.out.println(arr.get(0));
    }
}