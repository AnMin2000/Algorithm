import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		int[] dp2 = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			dp2[i] = 1;
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		for(int i = n; i >= 1; i--) {
			for(int j = i + 1; j <= n; j++) {
				if(arr[i] > arr[j]) dp2[i] = Math.max(dp2[i], dp2[j] + 1);
			}
		}
		
		
		int max = 0;
		for(int i = 1; i <= n; i++) {
			max = Math.max(dp[i] + dp2[i], max);
		}
		
		System.out.println(max - 1);
		
		
	}
}