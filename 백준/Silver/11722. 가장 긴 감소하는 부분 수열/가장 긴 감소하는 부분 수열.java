import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Arrays.fill(dp, 1);
			
		for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int max = 0;
		for(int j = n; j >= 1; j--) {
			for(int i = j + 1; i <= n; i++) {
				if(arr[j] > arr[i]) dp[j] = Math.max(dp[j], dp[i] + 1);
			}
			max = Math.max(dp[j], max);
		}
		System.out.println(max);
	}	
}