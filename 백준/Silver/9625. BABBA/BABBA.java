import java.util.*;
import java.io.*;

// 9625 : BABBA

/**
 * Example
 * 10
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_9625_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A = 1;
        int B = 0;

        for (int i = 0; i < N; i++) {
            int addA = B;
            int addB = A;

            A = addA;
            B += addB;
        }

        System.out.println(A + " " + B);
    }
}