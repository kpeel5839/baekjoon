import java.util.*;
import java.io.*;

// 17264 : I AM IRONMAN

/**
 * Example
 * 10 3
 * 20 15 100
 * JIHOON W
 * GANGYEOP L
 * MINSUNG L
 * JIHOON
 * MYEONGKI
 * GANGYEOP
 * MINSUNG
 * JIHOON
 * JIHOON
 * JIHOON
 * JIHOON
 * JIHOON
 * MINSUNG
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_17264_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] game = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // win, lose, g
        int score = 0;
        Map<String, Boolean> user = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            user.put(st.nextToken(), st.nextToken().charAt(0) == 'W');
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (!user.containsKey(s) || Boolean.TRUE.equals(!user.get(s))) {
                score = Math.max(0, score - game[1]);
            } else {
                score += game[0];
            }

            if (game[2] <= score) {
                System.out.println("I AM NOT IRONMAN!!");
                return;
            }
        }

        System.out.println("I AM IRONMAN!!");
    }
}
