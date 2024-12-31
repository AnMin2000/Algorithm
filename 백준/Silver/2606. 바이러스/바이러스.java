import java.util.*;
import java.io.*;

class Main{
    static int count;
    static int len;
    static int[][] cube;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        len = Integer.parseInt(br.readLine());
        cube = new int[len + 1][len + 1];
        visit = new boolean[len + 1];
        count = 0;
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            cube[x][y] = cube[y][x] = 1;
        }
        dfs(1);
       System.out.println(count - 1);
    }
    static void dfs(int start){
        count++;
        visit[start] = true;
        for(int i = 1; i <= len; i++){
            if(!visit[i] && cube[start][i] == 1) {
            	dfs(i);
            }
        }
    }
}