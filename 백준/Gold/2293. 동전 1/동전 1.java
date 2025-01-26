import java.util.*;



public class Main {
	
   public static void main(String[] args) {
	  
	   Scanner sc = new Scanner(System.in);

	   int n = sc.nextInt();
	   int coin = sc.nextInt();
	   
	   int[] dp = new int[coin + 1];
	   
	   for(int i = 0; i < n; i++) {
		   int s = sc.nextInt();
		   if(s <= coin) dp[s]++;
		   for(int j = s + 1; j <= coin; j++) {
				dp[j] += dp[j - s];			   
		   }
	   }
	   
	   System.out.println(dp[coin]);
	 
   }
}