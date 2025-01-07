// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.

// 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.


// 1번으로 돌아간다.

import java.util.*;
import java.io.*;

class Main{
    
    static int y, x, arrow;
    static int[][] xy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int currentY = Integer.parseInt(st.nextToken());
        int currentX = Integer.parseInt(st.nextToken());
        arrow = Integer.parseInt(st.nextToken());
        
        arr = new int[y][x];
        for(int j = 0; j < y; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < x; i++){
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(currentY, currentX);
        System.out.println(count);
        
    }
    static void dfs(int yy, int xx) {
    	if(arr[yy][xx] == 0) {
    		arr[yy][xx] = 2;
    		count++;
    	}
    	
    	for(int i = 0; i < 4; i++) {
    		arrow = (arrow + 3) % 4;
    		int Y = yy + xy[arrow][0];
    		int X = xx + xy[arrow][1];
    		
    		if(Y >= 0 && X >= 0 && X < x && Y < y && arr[Y][X] == 0) {
    			dfs(Y, X);
    			return;
    		}
    	}
    	
    	int Y = yy - xy[arrow][0];
    	int X = xx - xy[arrow][1];
    	
    	if(Y >= 0 && X >= 0 && Y < y && X < x && arr[Y][X] != 1) {
    		dfs(Y, X);
    	}
    }
    
}