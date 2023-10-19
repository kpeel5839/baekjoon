import java.util.*;
import java.io.*;

// 14600 : 샤워실 바닥 깔기 (Small)

/**
 * Example
 * 2
 * 3 2
 */
public class Main {

    public static int N;
    public static int[][] tiles;
    public static int count = 0;
    public static int id = 1;
    public static boolean end = false;

    public static int[] dx = {0, 1, 0, 1};
    public static int[] dy = {0, 0, 1, 1};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= N || x < 0 || x >= N;
    }

    public static void goNext(int y, int x) {
        dfs(y + (x == N - 1 ? 1 : 0), (x + 1) % N);
    }

    public static void dfs(int y, int x) {
        if (end) {
            return;
        }

        if (N * N - 1 == count) {
            Map<Integer, Integer> m = new HashMap();

            end = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tiles[i][j] == -1) {
                        System.out.print(-1);
                    } else if (m.containsKey(tiles[i][j])) {
                        System.out.print(m.get(tiles[i][j]));
                    } else if (!m.containsKey(tiles[i][j])) {
                        m.put(tiles[i][j], m.size() + 1);
                        System.out.print(m.size());
                    }

                    System.out.print(" ");
                }

                System.out.println();
            }
        }

        if (outOfRange(y, x)) {
            return;
        }

        List<int[]> list = new ArrayList<>();
        int zeroCount = 0;

        for (int i = 0; i < 4; i++) {
            if (outOfRange(y + dy[i], x + dx[i])) {
                continue;
            }

            if (tiles[y + dy[i]][x + dx[i]] == 0) {
                zeroCount++;
            }

            list.add(new int[] {y + dy[i], x + dx[i]});
        }

        if (list.size() != 4) {
            goNext(y, x);
            return;
        }

        if (zeroCount < 3) {
            goNext(y, x);
            return;
        }

        for (int c = 0; c < 4; c++) {
            int[] emptyPoint = new int[] {y + dy[c], x + dx[c]};
            boolean isPossible = true;

            for (int i = y; i < y + 2; i++) {
                for (int j = x; j < x + 2; j++) {
                    if (emptyPoint[0] == i && emptyPoint[1] == j) {
                        continue;
                    }

                    if (tiles[i][j] != 0) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                for (int[] p : list) {
                    if (emptyPoint[0] == p[0] && emptyPoint[1] == p[1]) {
                        continue;
                    }

                    tiles[p[0]][p[1]] = id;
                    count++;
                }

                id++;
                goNext(y, x);

                for (int[] p : list) {
                    if (emptyPoint[0] == p[0] && emptyPoint[1] == p[1]) {
                        continue;
                    }

                    tiles[p[0]][p[1]] = 0;
                    count--;
                }
            } else {
                goNext(y, x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_14600_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = (int) Math.pow(2, Integer.parseInt(br.readLine()));
        tiles = new int[N][N];
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = N - Integer.parseInt(st.nextToken());
        tiles[y][x] = -1;

        dfs(0, 0);

        if (!end) {
            System.out.println(-1);
        }
    }
}