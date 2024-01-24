import java.util.*;
import java.io.*;

// 10798 : 세로 읽기

/**
 * Example
 * ABCDE
 * abcde
 * 01234
 * FGHIJ
 * fghij
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/Algorithm_Baekjoon/_10798_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxLength = 0;
        String[] arr = new String[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
            maxLength = Math.max(maxLength, arr[i].length());
        }

        StringBuilder[] sb = new StringBuilder[maxLength];
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            sb[i] = new StringBuilder();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                sb[j].append(arr[i].charAt(j));
            }
        }

        for (int i = 0; i < sb.length; i++) {
            ans.append(sb[i]);
        }

        System.out.println(ans);
    }
}
