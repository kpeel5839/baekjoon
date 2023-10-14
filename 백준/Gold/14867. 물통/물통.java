import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 물통
// BFS ?
public class Main {
	static int a, b;
	static Set<String> visitedSet;	// 이전에 방문했는지 확인하기 위한 HashSet. 검색이 아주 빠르다. 2차원배열을 사용하기에는 범위가 너무 커서 안됨. 
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.valueOf(st.nextToken());
		b = Integer.valueOf(st.nextToken());
		int finishA = Integer.valueOf(st.nextToken());
		int finishB = Integer.valueOf(st.nextToken());
		visitedSet = new HashSet<String>();
		
		System.out.println(bfs(finishA, finishB));
	}
	
	static int bfs(int finishA, int finishB) {
		Queue<Point14867> q = new LinkedList<Point14867>();
		q.offer(new Point14867(0, 0));
		
		while(!q.isEmpty()) {
			Point14867 p = q.poll();
			int nowX = p.x;
			int nowY = p.y;
			if(nowX == finishA && nowY == finishB) {
				return p.count;
			}
			
			for(int i = 1; i <= 6; i++) {
				int x = nowX;
				int y = nowY;
				// 이미 차있는데, Full 하는거는 비효율적
				if(x == a && i == 1) {
					continue;
				}
				if(y == b && i == 2) {
					continue;
				}
				
				// 이미 비어있는데, Empty나 move 하는거는 비효율적
				if(x == 0) {	
					if(i == 3 || i == 5) {
						continue;	
					}
				}
				if(y == 0) {
					if(i == 4 || i == 6) {
						continue;	
					}
				}
				
//				Point14867 nextP = changeWater(p.x, p.y, i);
//        changeWater 함수 호출 대신 직접 내부 코드를 가져와 사용함. 효율성 증대를 위해(메모리  감소)
				switch(i) {
				// 1, 2 : Fill
				case 1:	// x만큼 채우기 
					x = a;
					break;
				case 2:	// y만큼 채우기
					y = b;
					break;
				// 3, 4 : Empty
				case 3:
					x = 0;
					break;
				case 4:
					y = 0;
					break;
				// 5, 6 : Move
				case 5:	// x -> y
					if(b - y < x) {
						x = x - (b - y);
						y = b;
					}
					else {
						y += x;
						x = 0;
					}
					break;
				case 6:	// y -> x
					if(a - x < y) {
						y = y - (a - x);
						x = a;
						
					}
					else {
						x += y;
						y = 0;
					}
					break;
				}
				
				if(isVisited(x, y)) {
					continue;
				}
				
//				nextP.setCount(p.count + 1);
				q.offer(new Point14867(x, y, p.count + 1));
			}
		}
		
		return -1;
	}
	
	// 방문한 적이 있는지 체크. 없으먼 방문 HashSet에 넣고 false.
	static boolean isVisited(int x, int y) {
		String point = x + "_" + y;
		if(visitedSet.contains(point)) {
			return true;
		}
		
		visitedSet.add(point);
		return false;
	}
	
	// 총 6가지의 방법을 통해 x와 y물통의 물의 양 바꾸기 
	static Point14867 changeWater(int x, int y, int menu) {
		switch(menu) {
		// 1, 2 : Fill
		case 1:	// x만큼 채우기 
			x = a;
			break;
		case 2:	// y만큼 채우기
			y = b;
			break;
		// 3, 4 : Empty
		case 3:
			x = 0;
			break;
		case 4:
			y = 0;
			break;
		// 5, 6 : Move
		case 5:	// x -> y
			if(b - y < x) {
				x = x - (b - y);
				y = b;
			}
			else {
				y += x;
				x = 0;
			}
			break;
		case 6:	// y -> x
			if(a - x < y) {
				y = y - (a - x);
				x = a;
				
			}
			else {
				x += y;
				y = 0;
			}
			break;
		}
		
		return new Point14867(x, y);
	}
}

class Point14867 {
	int x;
	int y;
	int count = 0;
	
	Point14867(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Point14867(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
	void setCount(int count) {
		this.count = count;
	}
}