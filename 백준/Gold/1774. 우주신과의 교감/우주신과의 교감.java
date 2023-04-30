import java.util.*;
import java.io.*;

// 1774 : 우주신과의 교감

/**
 * 예제
 * 4 1
 * 1 1
 * 3 1
 * 2 3
 * 4 3
 * 1 4
 */
public class Main {
    public static List<double[]> edges = new ArrayList<>();
    public static int[][] point;
    public static int N , M , count = 0;
    public static int[] parent;
    public static double res = 0;

    public static double getDis(int[] point1 , int[] point2){
        int y1 = point1[0] , x1 = point1[1];
        int y2 = point2[0] , x2 = point2[1];

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1 , 2));
    }
    public static void union(int a , int b){
        parent[b] = a;
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("/Users/jaeyeonkim/Desktop/CodingTest/CodingTest/BJ/Java/_1774_problem/src/input.txt"));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        point = new int[N][2];
        parent = new int[N + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            point[i] = new int[]{Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())};
            parent[i + 1] = i + 1;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());

            // 선택한 간선의 수를 업그레이드한다.
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 입력으로 받은 값 부모 찾아주고
            a = find(a);
            b = find(b);

            if (a == b) {
                continue;
            }

            // 서로 같은 집합에 포함시키면서 , 추후에 선택하지 못하게 한다.
            union(a , b);
            count++;
        }

        // edges 에다가 추가해준다.
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(i == j) continue;
                // 근데 번호는 1번 부터 시작하기 때문에 서로 번호를 + 1 해주어야 한다.

                // cost 얻어냄
                double cost = getDis(point[i] , point[j]);

                // 간선 추가
                edges.add(new double[]{i + 1 , j + 1 , cost});
            }
        }

        // edges cost 값으로 정렬 o1 이 더 크면 1을 반환하고 , 작으면 -1 을 반환하며 오름차순을 유지시킨다.
        Collections.sort(edges , (o1 , o2) -> Double.compare(o1[2], o2[2]));

        // 아직 다 선택된게 아니라면 , 진행한다.
        if(count != N - 1) {
            for (double[] edge : edges) {
                int a = find((int) edge[0]);
                int b = find((int) edge[1]);

                // 둘이 같은 집합이라면 continue (사이클 방지)
                if (a == b) continue;

                // 같은 집합이 아니라면 union 하고 , count++ 하고 , res 에다가 더해준다.
                union(a, b);
                count++;
                res += edge[2];

                // 간선을 N - 1 개 선택하게 되면 끝낸다.
                if (count == N - 1) break;
            }
        }

        System.out.println(String.format("%.2f" , res));
    }
}