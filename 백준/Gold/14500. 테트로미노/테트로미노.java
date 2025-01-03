import java.util.*;
import java.io.*;

class Main{
    
    static int N, M;
    static int[][] cube;
    static boolean[][] visit;
    static int max = 0;
    static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        cube = new int[N][M];
        visit = new boolean[N][M];
        
        for(int j = 0; j < N; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                cube[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int j = 0; j < N; j++){
            for(int i = 0; i < M; i++){
            	visit[j][i] = true;
                dfs(j, i, cube[j][i], 1);
                visit[j][i] = false;
            }
            
        }
        
        System.out.println(max);
        
    }
    static void dfs(int yy, int xx, int sum, int count){
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int y = yy + xy[i][0];
            int x = xx + xy[i][1];
            if(x >= 0 && y >= 0 && x < M && y < N && !visit[y][x]){
                if(count == 2){
                    visit[y][x] = true;
                    dfs(yy, xx, sum + cube[y][x], count + 1);
                    visit[y][x] = false;
                }
                
                visit[y][x] = true;
                dfs(y, x, sum + cube[y][x], count + 1);
                visit[y][x] = false;
                
            }
        }
    }
}