import java.util.*;
import java.io.*;

// 23057 : 도전 숫자왕

/**
 * Example
 * 3
 * 1 3 4
 */
public class Main {

    private static long calculateCombination(int n, int r) {
        long nn = 1;
        long rr = 1;

        for (long i = n; n - r < i; i--) {
            nn *= i;
        }

        for (long i = 2; i <= r; i++) {
            rr *= i;
        }

        return nn / rr;
    }

    public static int N;
    public static int[] arr;
    public static Set<Integer> possibleNumber = new HashSet<>();

    public static void combination(int index, int add) {
        possibleNumber.add(add);

        if (index == N) {
            return;
        }

        for (int i = index; i < N; i++) {
            combination(i + 1, add + arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_23057_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            M += arr[i];
        }

        for (int i = 0; i < N; i++) {
            combination(i + 1, arr[i]);
        }

        System.out.println(M - possibleNumber.size());
    }
}