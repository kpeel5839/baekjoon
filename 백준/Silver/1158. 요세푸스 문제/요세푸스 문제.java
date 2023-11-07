import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// 1158 : 요세푸스 순열

/**
 * Example
 * 7 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1158_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        int s = k - 1;
        for (int i = 0; i < n; i++) {
            s %= arr.size();
            res.add(arr.get(s));
            arr.remove(s);
            s += k - 1;
        }

        StringBuilder sb = new StringBuilder(res.toString());
        sb.setCharAt(0, '<');
        sb.setCharAt(sb.length() - 1, '>');
        System.out.println(sb);
    }
}
