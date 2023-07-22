import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1 };
	
	static int M, N;
	static int[][] map ;
	static int answer =0;
	static Queue<Point> queue ;
	static void bfs() {
		
		while ( !queue.isEmpty()) {
			
			Point p = queue.poll();
			
			for ( int d=0; d<8; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];
				
				if ( nr <0 || nr >= M || nc <0 || nc >= N || map[nr][nc] == 0 ) continue; // 경계 벗어나거나 글자 아니면 넘어가자
				
				map[nr][nc] = 0; // 방문처리 
				queue.add(new Point(nr,nc));
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<>();
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M][N];
		for ( int i=0; i<M; i++) {
			for ( int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for ( int i=0; i< M; i++) {
			for ( int j=0; j<N; j++) {
				if ( map[i][j] == 1 ) { // 글자를 발견하면
					answer ++; // 하나 찾았다!
					queue.add(new Point(i,j)); // 큐에 추가하고
					bfs();
					
				}
			}
		}
		System.out.println(answer);
	}
}