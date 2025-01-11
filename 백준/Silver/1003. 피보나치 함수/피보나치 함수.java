import java.io.*;
import java.util.*;
class Main{
	static int zero = 0;
	static int one = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
        	int m = Integer.parseInt(br.readLine());
        	if(m == 0) {
        		sb.append("1 0\n");
        		continue;
        	}
        	else if(m == 1) {
        		sb.append("0 1\n");
        		continue;
        	}
        	int[][] dp = new int[m + 1][2];
        	dp[0][0] = 1;
        	dp[0][1] = 0;
        	dp[1][0] = 0;
        	dp[1][1] = 1;
        	for(int i = 2; i <= m; i++) {
        		dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        		dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        	}
        	sb.append(dp[m][0] + " " + dp[m][1]+"\n");
        	
        }

        System.out.println(sb.toString());
    }

}