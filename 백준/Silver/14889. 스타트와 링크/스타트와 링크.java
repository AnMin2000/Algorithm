import java.util.*;
import java.io.*;

class Main{
    
    static int n;
    static int[][] cube;
    static int sum = 0;
    static int min = Integer.MAX_VALUE;
    static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        cube = new int[n][n];
        
        for(int j = 0; j < n; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                cube[j][i] = Integer.parseInt(st.nextToken());
                sum += cube[j][i];
            }
        }
        
        dfs(0);
        
        System.out.println(min);
        
        
        
    }
    static void dfs(int start){
        if(stack.size() == n / 2){
            int tmp = 0;
            int tmp2 = 0;
            for(int a : stack){
                for(int b : stack){
                    if(a == b) continue;
                    tmp += cube[a][b];
                }
            }
            for(int j = 0; j < n; j++) {
            	if(stack.contains(j)) continue;
            	for(int i = 0; i < n; i++) {
            		if(stack.contains(i)) continue;
            		tmp2 += cube[j][i];
            	}
            }
            min = Math.min(min, Math.abs(tmp - tmp2));
            return;
        }
        
        for(int i = start; i < n; i++){
            stack.push(i);
            dfs(i + 1);
            stack.pop();
        }
    }
}