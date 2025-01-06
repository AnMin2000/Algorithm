// 부수고 인벤 넣기 : 2초 / 블럭 쌓기 : 1초
import java.util.*;
import java.io.*;
class Main{
	static int y, x, b;
	static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        arr = new int[y][x];
        
        int max = 0;
        
        for(int j = 0; j < y; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < x; i++){
                arr[j][i] = Integer.parseInt(st.nextToken());       
                max = Math.max(max, arr[j][i]);
            }
        }
        
        int time = Integer.MAX_VALUE;
        int height = 0;
        for(int i = 0; i <= max; i++){
            int tmp = bruteForce(i);
            if(tmp == -1) continue;
            else if(time >= tmp){
                    time = tmp;
                    height = i;
            } 
        }
        
        System.out.println(time + " " + height);
        
    }
    static int bruteForce(int max){
        int time = 0;
        int block = b;
        for(int j = 0; j < y; j++){
            for(int i = 0; i < x; i++){
                if(arr[j][i] == max) continue;
                else if(arr[j][i] > max){
                    time += ((arr[j][i] - max) * 2);
                    block += (arr[j][i] - max);
                }
                else{
                    time += (max - arr[j][i]);
                    block -= (max - arr[j][i]);
                }
            }
        }
        
        if(block < 0){
            return -1;
        }
        else{
            return time;
        }
    }
}