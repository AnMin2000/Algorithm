import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			int num = (int)Math.sqrt(i);
			for(int j = 1; j <= num; j++) {
				dp[i] = Math.min(dp[i], i / (j * j) + dp[i % (j * j)]);

			}
			
		}
		System.out.println(dp[n]);
	}


}