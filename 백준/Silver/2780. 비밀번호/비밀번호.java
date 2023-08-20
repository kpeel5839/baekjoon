import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[1001][10];
		Arrays.fill(dp[1], 1);
		int divNum = 1_234_567;
		
		for (int i = 2; i <= 1000; i++) {
			dp[i][0] = dp[i-1][7]%divNum;
			dp[i][1] = (dp[i-1][2]+dp[i-1][4])%divNum;
			dp[i][2] = (dp[i-1][1]+dp[i-1][3]+dp[i-1][5])%divNum;
			dp[i][3] = (dp[i-1][2]+dp[i-1][6])%divNum;
			dp[i][4] = (dp[i-1][1]+dp[i-1][5]+dp[i-1][7])%divNum;
			dp[i][5] = (dp[i-1][2]+dp[i-1][4]+dp[i-1][6]+dp[i-1][8])%divNum;
			dp[i][6] = (dp[i-1][3]+dp[i-1][5]+dp[i-1][9])%divNum;
			dp[i][7] = (dp[i-1][4]+dp[i-1][8]+dp[i-1][0])%divNum;
			dp[i][8] = (dp[i-1][5]+dp[i-1][7]+dp[i-1][9])%divNum;
			dp[i][9] = (dp[i-1][6]+dp[i-1][8])%divNum;			
		}
		
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println((dp[num][0]+dp[num][1]+dp[num][2]+dp[num][3]+dp[num][4]+dp[num][5]+dp[num][6]+dp[num][7]+dp[num][8]+dp[num][9])%divNum);
		}
	}

}