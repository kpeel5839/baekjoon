import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// 28256 : 초콜릿 보관함

/**
 * Example
 * 6
 * OOO
 * O-O
 * XOO
 * 1 7
 * XOO
 * O-O
 * XXO
 * 2 1 4
 * OXO
 * O-X
 * XXO
 * 3 1 1 2
 * XOX
 * O-O
 * XOX
 * 4 1 1 1 1
 * XOO
 * O-O
 * OOX
 * 1 6
 * OXX
 * O-O
 * XXO
 * 3 1 1 2
 */
public class Main {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= 3 || x < 0 || x >= 3;
    }

    public static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx] == 0) {
                    continue;
                }

                q.add(new int[] {ny, nx});
                visited[ny][nx] = true;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_28256_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (T-- > 0) {
            map = new int[3][3];
            visited = new boolean[3][3];

            for (int i = 0; i < 3; i++) {
                String s = br.readLine();
                for (int j = 0; j < 3; j++) {
                    char c = s.charAt(j);

                    if (c == 'O') {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3;j ++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        list.add(bfs(i, j));
                    }
                }
            }

            Collections.sort(list);
            List<Integer> compare = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                compare.add(Integer.parseInt(st.nextToken()));
            }

            if (list.equals(compare)) {
                ans.append(1).append("\n");
            } else {
                ans.append(0).append("\n");
            }
        }

        System.out.println(ans);
    }
}