import java.util.*;
import java.io.*;

// 1445 : 일요일 아침의 데이트

/**
 * Example
 * 6 6
 * ......
 * g..F..
 * ......
 * ..g...
 * ......
 * ...S.g
 */
public class Main {

    public static int H;
    public static int W;
    public static int[] start;
    public static int[] destination;
    public static char[][] map;
    public static int[][][] garbage;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void garbageInit() {
        garbage = new int[H][W][2];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'g') {
                    garbage[i][j][0] = 1;
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];

                        if (outOfRange(ny, nx)) {
                            continue;
                        }

                        garbage[ny][nx][1] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'g') {
                    garbage[i][j][1] = 0;
                }
            }
        }

        garbage[destination[0]][destination[1]][0] = 0;
        garbage[destination[0]][destination[1]][1] = 0;
        garbage[start[0]][start[1]][0] = 0;
        garbage[start[0]][start[1]][1] = 0;
    }

    public static void dijkstra() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                return o1[3] - o2[3];
            }

            return o1[2] - o2[2];
        });

        int[][][] dist = new int[H][W][2];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        q.add(new int[] {start[0], start[1], 0, 0});
        dist[start[0]][start[1]][0] = 0;
        dist[start[0]][start[1]][1] = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            if (p[0] == destination[0] && p[1] == destination[1]) {
                System.out.println(p[2] + " " + p[3]);

//                for (int i = 0; i < H; i++) {
//                    for (int j = 0; j < W; j++) {
//                        System.out.format(
//                                "[%s, %s]",
//                                dist[i][j][0] == Integer.MAX_VALUE ? 0 : dist[i][j][0],
//                                dist[i][j][1] == Integer.MAX_VALUE ? 0 : dist[i][j][1]
//                        );
//                    }
//                    System.out.println();
//                }
                return;
            }

            if (!(dist[p[0]][p[1]][0] == p[2] && dist[p[0]][p[1]][1] == p[3])) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];

                if (outOfRange(ny, nx)) {
                    continue;
                }

                int nog = p[2] + garbage[ny][nx][0];
                int nsg = p[3] + garbage[ny][nx][1];

                if (isPossible(dist[ny][nx], nog, nsg)) {
                    dist[ny][nx][0] = nog;
                    dist[ny][nx][1] = nsg;
                    q.add(new int[] {ny, nx, nog, nsg});
                }
            }
        }
    }

    public static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }

    public static boolean isPossible(int[] origin, int nog, int nsg) {
        if (origin[0] == nog) {
             return nsg < origin[1];
        }

        return nog < origin[0];
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1445_problem/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        garbage = new int[H][W][2];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = s.charAt(j);
                map[i][j] = c;

                if (c == 'S') {
                    start = new int[] {i, j};
                    map[i][j] = '.';
                } else if (c == 'F') {
                    destination = new int[] {i, j};
                    map[i][j] = '.';
                }
            }
        }

        garbageInit();
        dijkstra();
    }
}