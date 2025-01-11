import java.io.*;
import java.util.*;
class Main{
	static int zero = 0;
	static int one = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] dp = new long[101];
        
        dp[1] = dp[2] = 1;
        
        for(int i = 3; i <= 100; i++) dp[i] = dp[i - 2] + dp[i - 3];
        
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
        	int m = Integer.parseInt(br.readLine());
        	sb.append(dp[m] + "\n");
        }
        
        
        System.out.println(sb.toString());
    }

}