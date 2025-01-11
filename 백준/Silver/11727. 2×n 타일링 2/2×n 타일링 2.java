import java.io.*;
import java.util.*;
class Main{
	static int zero = 0;
	static int one = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n == 1) {
        	System.out.println(1);
        	return;
        }
        else if(n == 2) {
        	System.out.println(3);
        	return;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i = 3; i <= n; i++) dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        
        System.out.println(dp[n]);
        
        
    }

}