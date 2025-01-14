import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n + 1][10];
		Arrays.fill(dp[1], 1);
		
		for(int j = 2; j <= n; j++) {
			for(int i = 0; i <= 9; i++) {
				for(int k = i; k <= 9; k++) {
					dp[j][i] += dp[j - 1][k];
				}
				dp[j][i] %= 10007;
			}
		}
		
		int sum = 0;
		for(int i = 0; i <= 9; i++) sum += dp[n][i];
		
		System.out.println(sum % 10007);
	}
}