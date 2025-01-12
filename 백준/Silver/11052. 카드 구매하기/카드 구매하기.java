import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int j = 1; j <= n; j++) {
			for(int i = j; i <= n; i++) {
				dp[i] = Math.max(dp[j] * (i / j) + dp[i % j], dp[i]);
			}
			
		}

	System.out.println(dp[n]);
		
		
	}
}