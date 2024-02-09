import java.util.*;
import java.io.*;
import java.util.function.Function;

// 7569 : 토마토

/**
 * -- 전제 조건
 * 이전에 풀었던 토마토 문제와 굉장히 흡사한데,
 * 근데, 이것은 3차원이다.
 *
 * 이전 처럼 -1 은 비어있는 곳, 그리고 0 은 아직 익지 않은 토마토, 그리고 1은 익은 토마토라고 하고,
 * 다 익었을 때의, 시간을 구해보자.
 * -- 틀 설계
 * 그냥 3차원 배열로 선언을 하고,
 * dz, dy, dx 로 진행을 해서, 3차원 bfs 를 할 수 있도록 한다
 *
 * 주의할 점은, 토마토가 다 익었는지 확인하는 과정과,
 * 그리고, 처음에 토마토의 정보를 받으면서, 잘 담는 것이다.
 */
public class Main {
    public static int X;
    public static int Y;
    public static int Z;
    public static int res = 0;

    public static int[] dz = {0, 0, 0, 0, 1, -1}; // z축으로 위, 아래
    public static int[] dy = {-1, 0, 1, 0, 0, 0}; // y축으로 위, 아래
    public static int[] dx = {0, 1, 0, -1, 0, 0}; // 오른쪽, 왼쪽

    public static int[][][] map;
    public static boolean[][][] visited;

    public static Queue<int[]> queue = new LinkedList<>();

    public static void bfs() {
        // 가장 큰 value 값을 res 와 비교하여서, 계속 갱신한다.
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            res = Math.max(res, point[3]);

            for (int i = 0; i < 6; i++) {
                int nz = point[0] + dz[i];
                int ny = point[1] + dy[i];
                int nx = point[2] + dx[i];

                if (outOfRange(nz, ny, nx) || visited[nz][ny][nx] || map[nz][ny][nx] == -1) {
                    continue;
                }

                visited[nz][ny][nx] = true;
                map[nz][ny][nx] = 1; // map 에 익었다는 표시
                queue.add(new int[]{nz, ny, nx, point[3] + 1});
            }
        }

        if (check()) { // 만일 bfs 가 끝났는데, check 했는데, 0이 있다면? 그러면 끝나지 않은 것임
            res = -1;
        }
    }

    public static boolean outOfRange(int z, int y, int x) {
        if ((z < 0 || z >= Z) || (y < 0 || y >= Y) || (x < 0 || x >= X)) {
            return true;
        }

        return false;
    }

    // 게임이 끝났는지 안끝났는지를 정보를 알려줄 check
    public static boolean check() {
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                for(int c = 0; c < X; c++) {
                    if (map[i][j][c] == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> fun = Integer::parseInt;

        String[] input = br.readLine().split(" ");
        X = fun.apply(input[0]);
        Y = fun.apply(input[1]);
        Z = fun.apply(input[2]);

        map = new int[Z][Y][X];
        visited = new boolean[Z][Y][X];

        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Y; j++) {
                input = br.readLine().split(" ");
                for(int c = 0; c < X; c++) {
                    map[i][j][c] = fun.apply(input[c]);

                    if (map[i][j][c] == 1) {
                        queue.add(new int[]{i, j, c, 0});
                        visited[i][j][c] = true; // 방문처리
                    } // 4 번째 값은, value 확산될 때마다, 1씩 증가한다.

                }
            }
        }

        bfs();
        System.out.println(res);
    }
}
