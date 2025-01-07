import java.util.*;
import java.io.*;
class Main{
    static int n;
    static int[][] arr;
    static Queue<String[]> queue = new LinkedList<>();
    static LinkedList<int[]> tail = new LinkedList<>();
    static int[][] xy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n + 1][n + 1];
        int apple = Integer.parseInt(br.readLine());
        for(int i = 0; i < apple; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] tmp = {st.nextToken(), st.nextToken()};
            queue.offer(tmp);
        }
        bfs();
        
        System.out.println(count);
        
    }
    static void bfs(){
        int currentArrow = 1;
        int y = 1;
        int x = 1;
        int time = 0;
        String arrow = "";
        tail.add(new int[] {y, x});
        while(true){
            if(!queue.isEmpty()){
                String[] tmp = queue.poll();
                time = Integer.parseInt(tmp[0]);
                arrow = tmp[1];
            }
            
            
            while(true){
                count++;
                //if(count == 1) return;
                y = y + xy[currentArrow][0];
                x = x + xy[currentArrow][1];
                
                if(check(y, x)){
                    if(arr[y][x] == 1) {
                    	tail.add(new int[] {y, x});
                    	arr[y][x] = 0;
                    }
                    else if(!tail.isEmpty()){
                    	tail.poll();
                    	tail.add(new int[]{y, x});
                    	
                    }
                }
                else return;
                
                if(count == time){
                	if(arrow.equals("D")) currentArrow = (currentArrow + 3) % 4;
                	else currentArrow = (currentArrow + 1) % 4;
                	break;
                }
            }
        }  
    }
    static boolean check(int y, int x){
        if(y >= 1 && x >= 1 && y <= n && x <= n){
            for(int i = 0; i < tail.size(); i++){
                int tmp[] = tail.get(i);
                if(tmp[0] == y && tmp[1] == x) return false;
            }
            return true;
        }
        else return false;
        
    }
}