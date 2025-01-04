import java.util.*;
import java.io.*;
class Main{
    
    static int y, x;
    static char[][] cube;
    static boolean[][][] visit;
    static Queue<int[]> queue = new LinkedList<>();
    static int result = -1;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        visit = new boolean[y][x][2];
        cube = new char[y][x];
        
        for(int j = 0; j < y; j++){  
            cube[j] = br.readLine().toCharArray();
        }
        
        queue.offer(new int[]{0, 0, 1, 0});
        bfs();
        System.out.println(result);
    }
    static void bfs(){
        int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        visit[0][0][0] = true;
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int y1 = arr[0];
            int x1 = arr[1];
            int ctn = arr[2];
            int check = arr[3];
            
            
            if(y1 == y - 1 && x1 == x - 1){
            	result = ctn;
                return;
            }
            
            for(int i = 0; i < 4; i++){
                int y2 = y1 + xy[i][0];
                int x2 = x1 + xy[i][1];
                
                
                if(y2 >= 0 && x2 >= 0 && y2 < y && x2 < x) {
                	if(cube[y2][x2] == '0' && !visit[y2][x2][check]){
                        visit[y2][x2][check] = true;
                        queue.offer(new int[] {y2, x2, ctn + 1, check});
                    }
                    else if(cube[y2][x2] == '1' && check == 0 && !visit[y2][x2][1]){
                        visit[y2][x2][1] = true;
                        queue.offer(new int[] {y2, x2, ctn + 1, 1});
                    }
                }
                
                
                
            }
        }
    }
}
