import java.util.*;
import java.io.*;
import java.util.function.Function;

// 30036 : INK

/**
 * Example
 * 3 4 12
 * RGB
 * .@..
 * .##.
 * .##.
 * ....
 * jJRRJjjDDjDJ
 */
public class Main {

    public static int I;
    public static int N;
    public static int K;
    public static char[][] map;
    public static int jumpCount = 0;
    public static int ink = 0;
    public static String INK_STRING;
    public static String s;
    public static int[] startPosition;
    public static List<int[]> obstacle = new ArrayList<>();
    public static Map<Character, Function<int[], int[]>> m = Map.of(
            'U', o -> new int[] {o[0] - 1, o[1]},
            'D', o -> new int[] {o[0] + 1, o[1]},
            'L', o -> new int[] {o[0], o[1] - 1},
            'R', o -> new int[] {o[0], o[1] + 1}
    );

    public static void solution() {
        int index = 0;
        int[] nowPosition = new int[] {startPosition[0], startPosition[1]};

        while (index != s.length()) {
            char c = s.charAt(index++);

            if (m.containsKey(c)) {
                int[] newPosition = m.get(c).apply(nowPosition);
                if (outOfRange(newPosition[0], newPosition[1]) || map[newPosition[0]][newPosition[1]] != '.') {
                    continue;
                }
                map[nowPosition[0]][nowPosition[1]] = '.';
                map[newPosition[0]][newPosition[1]] = '@';
                nowPosition = new int[] {newPosition[0], newPosition[1]};
            }

            if (c == 'j') {
                ink++;
            }

            if (c == 'J') {
                char color = inkColor();

                for (int[] position : obstacle) {
                    if (isRange(nowPosition[0], nowPosition[1], position[0], position[1])) {
                        map[position[0]][position[1]] = color;
                    }
                }

                ink = 0;
                jumpCount++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static boolean isRange(int sy, int sx, int dy, int dx) {
        return (Math.abs(sy - dy) + Math.abs(sx - dx)) <= ink;
    }

    public static char inkColor() {
        return INK_STRING.charAt(jumpCount % INK_STRING.length());
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_30036_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        I = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        INK_STRING = br.readLine();

        for (int i = 0; i < N; i++) {
            String ss = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = ss.charAt(j);

                if (map[i][j] == '@') {
                    startPosition = new int[] {i, j};
                } else if (map[i][j] == '#') {
                    obstacle.add(new int[] {i, j});
                }
            }
        }

        s = br.readLine();
        solution();
    }
}