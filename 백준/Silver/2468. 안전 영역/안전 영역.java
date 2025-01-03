import java.util.*;
import java.io.*;

class Main{
    static int n;
    static boolean[][] visit;
    static int[][] cube;
    static int count = 0;
    static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        cube = new int[n][n];
        visit = new boolean[n][n];
        int cutLine = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                cube[i][j] = Integer.parseInt(st.nextToken());
                cutLine = Math.max(cutLine, cube[j][i]);
            }
        }
        
        int max = 1;
        for(int k = 1; k <= cutLine; k++){
           

            int ctn = 0;
            for(int j = 0; j < n; j++){
                for(int i = 0; i < n; i++){
                    if(!visit[j][i] && cube[j][i] > k){
                        dfs(j,i,k);
                        ctn++;

                    }  
                }
            }
            visit = new boolean[n][n];
            max = Math.max(max,ctn);
        }
        System.out.println(max);

        
    }
    
    static void dfs(int yy, int xx, int k){
        visit[yy][xx] = true;
        
        for(int i = 0; i < 4; i++){
            int y = yy + xy[i][0];
            int x = xx + xy[i][1];
            
            if(x >= 0 && y >= 0 && x < n && y < n && !visit[y][x] && cube[y][x] > k){
                dfs(y, x, k);
            }
        }
        
    }
}