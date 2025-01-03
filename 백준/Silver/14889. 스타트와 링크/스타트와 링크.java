import java.util.*;
import java.io.*;

class Main{
    
    static int n;
    static int[][] cube;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        cube = new int[n][n];
        visit = new boolean[n];
        for(int j = 0; j < n; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                cube[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        
        System.out.println(min);
        
        
        
    }
    static void dfs(int start, int count){
    	
        if(count == n / 2) {
        	int tmp = 0;
        	int tmp2 = 0;
        	for(int j = 0; j < n; j++) {
        		for(int i = 0; i < n; i++) {
        			if(j == i) continue;
        			
        			if(visit[j] && visit[i]) tmp += cube[j][i];
        			else if(!visit[j] && !visit[i]) tmp2 += cube[j][i];
        		}
        	}
            min = Math.min(min, Math.abs(tmp - tmp2));
            return;
        }
        
        for(int i = start; i < n; i++){
            visit[i] = true;
            dfs(i + 1, count + 1);
            visit[i] = false;
        }
    }
}