import java.math.BigInteger;
import java.util.*;
import java.io.*;

// 1793 : 타일링

/**
 * Example
 * 2
 * 8
 * 12
 * 100
 * 200
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_1793_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger[] b = new BigInteger[251];
        b[0] = BigInteger.ONE;
        b[1] = BigInteger.ONE;

        for (int i = 2; i <= 250 ;i++) {
            b[i] = b[i - 1].add(b[i - 2].multiply(BigInteger.TWO));
        }

        while (true) {
            String s = br.readLine();

            if (s == null) {
                break;
            }

            int N = Integer.parseInt(s);
            sb.append(b[N]).append("\n");
        }

        System.out.println(sb);
    }
}