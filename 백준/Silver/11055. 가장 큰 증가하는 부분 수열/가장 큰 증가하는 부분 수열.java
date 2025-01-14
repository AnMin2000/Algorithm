import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) dp[i] = arr[i] = Integer.parseInt(st.nextToken());
		
		int max = 0;
		for(int j = 1; j <= n; j++) {
			for(int i = 1; i < j; i++) {	
				if(arr[j] > arr[i]) dp[j] = Math.max(dp[j], dp[i] + arr[j]);
			}
			max = Math.max(max, dp[j]);
		}
		
		System.out.println(max);
	}
}