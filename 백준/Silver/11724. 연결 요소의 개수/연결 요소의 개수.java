import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    static int[][] arr;
    static boolean[] visit;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            
            arr[y][x] = arr[x][y] = 1;
        }
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        
        System.out.println(count);
    }
    static void dfs(int start){
        visit[start] = true;
        for(int i = 1; i <= N; i++){
            if(!visit[i] && arr[start][i] == 1){
                dfs(i);
            }
        }
    }
}