import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 네트워크 복구
// 다익스트라 알고리즘 
public class Main {
	static int[][] map;
	static int[] distance;
	static boolean[] visited;
	static HashSet<String> resultSet;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		map = new int[n + 1][n + 1]; // index : 1 ~ N
		distance = new int[n + 1];
		visited = new boolean[n + 1];
		resultSet = new HashSet<String>();
		
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			int time = Integer.valueOf(st.nextToken());
			
			map[start][end] = time;
			map[end][start] = time;	
		}
		
		dijkstra(1, n);
		
		// 결과 출력
		System.out.println(resultSet.size());
		for(String str : resultSet) {
			System.out.println(str);
		}
	}
	
	// start -> 1 까지 가는 최단 시간 경로 탐색 (다익스트라 알고리즘) 
	static void dijkstra(int start, int n) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		int[] path = new int[n + 1];	//최단경로를 파악하기 위해 생성 
		PriorityQueue<Vertex2211> q = new PriorityQueue<Vertex2211>();
		distance[start] = 0;
		
		q.offer(new Vertex2211(start, distance[start]));
		
		while(!q.isEmpty()) {
			Vertex2211 v = q.poll();
			int nowPoint = v.start;
			visited[nowPoint] = true;
			
			for(int i = 1; i <= n; i++) {
				if(map[nowPoint][i] != 0) {
					if(!visited[i] && (distance[i] > distance[nowPoint] + map[nowPoint][i])) {
						distance[i] = distance[nowPoint] + map[nowPoint][i];
						q.offer(new Vertex2211(i, distance[i]));
						path[i] = nowPoint;	// path[end] = start
					}
				}
			}
		}
		
		// 각 도착지점부터 시작해서 역으로 거슬러올라가며 경로를 찾고, HashSet에 담는다.
		for(int i = 2; i <= n; i++) {
			int end = i;
			while(path[end] != 0) {
				resultSet.add(new String(end + " " + path[end]));
				end = path[end];
			}
		}
	}
}

class Vertex2211 implements Comparable<Vertex2211> {
	int start;
	int end;
	int time;
	Vertex2211(int start) {
		this.start = start;
	}
	
	Vertex2211 (int start, int time) {
		this.start = start;
		this.time = time;
	}

	@Override
	public int compareTo(Vertex2211 o) {
		if(this.time < o.time) {
			return -1;
		}
		else {
			return 1;
		}
	}
}