import java.util.*;
import java.io.*;

// 3077 : 임진왜란

/**
 * Example
 * 5
 * okpo sacheon hansan myeongnyang noryang
 * sacheon hansan myeongnyang noryang okpo
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_3077_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        String[] ss = new String[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map.put(st.nextToken(), i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ss[i] = st.nextToken();
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (map.get(ss[i]) < map.get(ss[j])) {
                    ans++;
                }
            }
        }

        System.out.println(ans + "/" + ((N * (N - 1)) / 2));
    }
}