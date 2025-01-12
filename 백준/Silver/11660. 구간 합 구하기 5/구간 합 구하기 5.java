import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[n + 1][n + 1];
		for(int j = 1; j <= n; j++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++) {
				dp[j][i] = dp[j - 1][i] + dp[j][i - 1] + Integer.parseInt(st.nextToken()) - dp[j - 1][i - 1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			sb.append(dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1]  + dp[y1 - 1][x1 -1] + "\n");
		}

		
		System.out.println(sb.toString());
		
		
	}
}