import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	private static double result;
	
	private static boolean[] isChecked;
	
	private static int[][] P;

	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 케이스 수
		int T = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < T; i++)
		{
			// 점의 갯수
			int N = Integer.parseInt(reader.readLine());
			
			result = Double.MAX_VALUE;
			
			isChecked = new boolean[N];
			
			P = new int[N][2];
			
			for (int j = 0; j < N; j++)
			{
				String[] temp = reader.readLine().split(" ");
				
				P[j][0] = Integer.parseInt(temp[0]);
				P[j][1] = Integer.parseInt(temp[1]);
			}
			
			combination(0, N / 2);
			
			System.out.println(result);
		}
		
		reader.close();
	}

	private static void combination(int index, int count)
	{
		// 조합할 원소 갯수가 더 이상 없을 경우
		if (count == 0)
		{
			result = Math.min(result, getVector());
		}
		
		// 조합할 원소 갯수가 아직 남아있을 경우
		else
		{
			for (int i = index; i < P.length; i++)
			{
				isChecked[i] = true;
				
				combination(i + 1, count - 1);
				
				isChecked[i] = false;
			}
		}
	}
	
	private static double getVector()
	{
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < P.length; i++)
		{
			// 양수로 선택된 점일 경우
			if (isChecked[i])
			{
				x += P[i][0];
				y += P[i][1];
			}
			
			// 음수로 선택된 점일 경우
			else
			{
				x -= P[i][0];
				y -= P[i][1];
			}
		}
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}