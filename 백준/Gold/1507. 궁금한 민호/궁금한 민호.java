import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
    static final int INF = 987654321;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1]; // 원래 주어진 배열
        int[][] arr = new int[N + 1][N + 1]; // 플로이드 와샬 알고리즘 수행 전 배열
        boolean[][] check = new boolean[N + 1][N + 1];
 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dist[i][j];
            }
        }
 
        // 플로이드 와샬 알고리즘 수행
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // i == k 와 k == j인 경우를 거르지 않으면
                    // 거쳐가지 않는 간선도 모조리 없애게 될 수 있음.
                    // 예를 들어 i = 1, k = 1, j = 2일 경우
                    // 1에서 2로 가기 위해 거쳐가는 정점이 없는데
                    // 1 -> 2 간선을 없애게 될 수 있음.
                    if (i == j || i == k || k == j) {
                        continue;
                    }
 
                    // dist는 플로이드 와샬 알고리즘을 이미 수행한 상태인데
                    // 또 최단거리를 초기화할 부분이 생기면 모순.
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        bw.write("-1\n");
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
 
                    // 거쳐가는 지점을 통해서 최단거리가 초기화된 부분이 있다면
                    // i -> j 간선을 없앰.
                    if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        arr[i][j] = INF;
                    }
                }
            }
        }
 
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF && i != j && !check[i][j]) {
                    ans += arr[i][j];
                    check[i][j] = check[j][i] = true;
                }
            }
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}