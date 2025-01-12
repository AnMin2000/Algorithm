import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N + 1];
		
		if(N <= 2) {
			System.out.println(1);
			return;
		}
		dp[2] = dp[1] = 1;
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.print(dp[N]);
	}
}