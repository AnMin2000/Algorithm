import java.util.*;
import java.io.*;
class Main{
    static int x, y, count, check;
    static int[][] arr;
    static int[][] xy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        
        
        arr = new int[y][x];
        count = 0;
        check = 0;
        for(int j = 0; j < y; j++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = 0; i < x; i++){
                arr[j][i] = Integer.parseInt(st2.nextToken());
                if(arr[j][i] == 0) count++;
                if(arr[j][i] == 1) queue.offer(new int[]{j, i});
            }
        }
        bfs();
        
        if(count == 0) System.out.println(check - 1);
        else System.out.println(-1);

    }
    static void bfs(){
        
        while(!queue.isEmpty()){
            
            int len = queue.size();
            
            for(int k = 0; k < len; k++){
                int[] tmp = queue.poll();
                int yy = tmp[0];
                int xx = tmp[1];

                for(int i = 0; i < 4; i++){

                    int Y = yy + xy[i][0];
                    int X = xx + xy[i][1];

                    if(X < x && Y < y && X >= 0 && Y >= 0 && arr[Y][X] == 0){
                        count--;
                        arr[Y][X] = 1;
                        queue.offer(new int[] {Y, X});
                    }
                }
            }
            check++;
        }
        
    }
}