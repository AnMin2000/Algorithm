import java.util.*;
import java.io.*;

class Main{
    static int M, N;
    static boolean[][] visit;
    static int[][] box;
    static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int count = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
        int K = Integer.parseInt(st.nextToken()); // 직사각형 개수
        
        box = new int[M][N];
        visit = new boolean[M][N];
        
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int k = y1; k < y2; k++){
                for(int m = x1; m < x2; m++){
                    box[k][m] = 1;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        int check = 0;
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N; i++){
                if(!visit[j][i] && box[j][i] == 0){
                    dfs(j, i);
                    list.add(count);
                    count = 0;
                    check++;
                }
            }
        }
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        sb.append(check + "\n");
        for(int a : list) sb.append(a + " ");
        System.out.println(sb.toString());
    }
    static void dfs(int yy, int xx){
        count++;
        visit[yy][xx] = true;
        for(int i = 0; i < 4; i++){
            int y = yy + xy[i][0];
            int x = xx + xy[i][1];
            
            if(y >= 0 && x >= 0 && y < M && x < N && !visit[y][x] && box[y][x] == 0){
                dfs(y, x);
            }
        }
    }
}