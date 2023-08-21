import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

// 지름길
// 최단거리(다익스트라?) -> 1씩 이동하면서 지름길 및 거리 계산 수행한다고 가정 
// 그래프 
public class Main {
	static int n, d;
	static int[] movedDistance;	// 최단 으로 운전한 거리  
	static ShortCut[] shortCuts;
	
	public static void main(String args[]) {
		InputReader in = new InputReader(System.in);
		n = in.readInt();
		d = in.readInt();
		movedDistance = new int[d + 1];
		shortCuts = new ShortCut[n];
		
		// 초기화
		Arrays.fill(movedDistance, Integer.MAX_VALUE);
		
		// 지름길 입력받기 
		for(int i = 0; i < n; i++) {
			int start = in.readInt();
			int end = in.readInt();
			int dist = in.readInt();
			
			shortCuts[i] = new ShortCut(start, end, dist);
		}
		
		// 시작점 기준 오름차순 정렬 
		Arrays.sort(shortCuts);
		
		int nowDistance = 0;
		int nowIndex = 0;
		movedDistance[0] = 0;
		
		while(nowDistance < d) {
			while(nowIndex < n) {
				if(shortCuts[nowIndex].start != nowDistance) {
					break;
				}
				
				// 지름길 이동 
				if(shortCuts[nowIndex].end <= d) {
					int goShortCutDistance = movedDistance[nowDistance] + shortCuts[nowIndex].distance;
					if(goShortCutDistance < movedDistance[shortCuts[nowIndex].end]) {
						movedDistance[shortCuts[nowIndex].end] = goShortCutDistance;
					}
				}
			
				nowIndex++;
			}
			
			// 한 칸 이동 
			if(movedDistance[nowDistance] + 1 < movedDistance[nowDistance + 1]) {
				movedDistance[nowDistance + 1] = movedDistance[nowDistance] + 1;
			}
			
			nowDistance++;
		}
		
		System.out.println(movedDistance[d]);
	}
	
	// INPUT 속도 증가
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}

class ShortCut implements Comparable<ShortCut> {
	int start;
	int end;
	int distance;
	
	ShortCut(int start, int end, int distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	@Override
	public int compareTo(ShortCut o) {
		if(this.start < o.start) {
			return -1;
		}
		return 1;
	}
}