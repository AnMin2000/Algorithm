import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[] dp = new boolean[1001];
		
		dp[1] = true;
		
		for(int i = 1; i <= 997; i++) dp[i + 3] = dp[i + 1] = !dp[i];
		
		if(dp[n]) System.out.println("SK");
		else System.out.println("CY");
		
	}
}