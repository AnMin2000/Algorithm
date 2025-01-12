import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		String M = br.readLine();
		
		int nLen = N.length();
		int mLen = M.length();
		long[][] dp = new long[nLen + 1][mLen + 1];
		
		for(int j = 1; j <= nLen; j++) {
			for(int i = 1; i <= mLen; i++) {
				if(N.charAt(j - 1) == M.charAt(i - 1)) dp[j][i] = dp[j - 1][i - 1] + 1;
				else dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);
			}
		}
		
		System.out.println(dp[nLen][mLen]);
		
		
	}
}