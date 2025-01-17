import java.util.*;



public class Main {

	static int x, y;
	static List<Character> visit;
	static char[][] alpa;
	static int max;
   public static void main(String[] args) {
      
	   Scanner sc = new Scanner(System.in);
	   
	   y = sc.nextInt();
	   x = sc.nextInt();
	   
	   visit = new ArrayList<>();
	   alpa = new char[y][x];
	   
	   for(int j = 0; j < y; j++) {
		   alpa[j] = sc.next().toCharArray();
	   }
	   max = 0;
	   dfs(0,0,1);

	   System.out.println(max);
     
   }
   
   static void dfs(int j, int i, int count) {
	   max = Math.max(max, count);
	   visit.add(alpa[j][i]);
	   if(i - 1 >= 0 && !visit.contains(alpa[j][i-1])) {
		   dfs(j, i-1, count + 1); 
		   visit.remove(visit.size()-1);
	   }
	   if(i + 1 < x && !visit.contains(alpa[j][i+1])) {
		   dfs(j, i+1, count + 1); 
		   visit.remove(visit.size()-1);
	   }
	   if(j - 1 >= 0 && !visit.contains(alpa[j-1][i])) {
		   dfs(j-1, i, count + 1); 
		   visit.remove(visit.size()-1);
	   }
	   if(j + 1 < y && !visit.contains(alpa[j+1][i])) {
		   dfs(j+1, i, count + 1);	  
		   visit.remove(visit.size()-1);
	   }
   }
}