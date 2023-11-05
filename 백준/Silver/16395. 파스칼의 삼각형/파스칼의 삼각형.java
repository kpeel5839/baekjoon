import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 16395 : 파스칼의 삼각형

/**
 * Example
 * 11 3
 */
public class Main {

    public static BigInteger calculate(int N, int M) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");

        for (int i = N; N - M < i; i--) {
            a = a.multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i = 1; i <= M; i++) {
            b = b.multiply(new BigInteger(String.valueOf(i)));
        }

        return a.divide(b);
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_16395_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(calculate(N - 1, M - 1));
    }
}