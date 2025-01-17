import java.util.*;



public class Main {

	static int n, count;
	static char [][]ch;
	static boolean [][] visit;
	static int[] villa;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
     
      n = sc.nextInt();
      
      ch = new char[n][n];
      visit = new boolean[n][n];
      count = 0;
      for(int i = 0; i < n; i++	) {
    	  ch[i] = sc.next().toCharArray(); 
      }
      villa = new int[n*n];
      
      for(int j = 0; j < n; j++) {
    	  for(int i = 0; i < n; i++) {
    		  if(ch[j][i] == '1' && !visit[j][i]) {
    			  count++;
    			  dfs(j, i);
    		  }
    	  }
      }
      List<Integer> list = new ArrayList<>();
      for(int i = 0; i < n*n; i++) {
    	  if(villa[i] > 0) {
    		  list.add(villa[i]);
    	  }
      }
      
      Collections.sort(list);
      
      System.out.println(count);
      for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
      
      
   }
   
   static void dfs(int x, int y) {
	   visit[x][y] = true;
	   villa[count]++;
	   
	  
		if(x - 1 >= 0 && ch[x - 1][y] == '1' && !visit[x - 1][y]) dfs(x - 1, y);
		   if(x + 1 < n && ch[x + 1][y] == '1' && !visit[x + 1][y]) dfs(x + 1, y);
		   if(y - 1 >= 0 && ch[x][y - 1] == '1' && !visit[x][y - 1]) dfs(x, y - 1);
		   if( y + 1 < n && ch[x][y + 1] == '1' && !visit[x][y + 1]) dfs(x, y + 1);   

   }
}