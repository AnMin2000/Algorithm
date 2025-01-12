import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(n-->0) {
			int m = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][m + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= m; i++) dp[0][i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= m; i++) dp[1][i] = Integer.parseInt(st.nextToken());
			
			for(int i = 2; i <= m; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + dp[0][i]; 
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + dp[1][i]; 
			}
			sb.append(Math.max(dp[0][m], dp[1][m]) + "\n");
		}
		
		System.out.println(sb.toString());
		
		
	}
}