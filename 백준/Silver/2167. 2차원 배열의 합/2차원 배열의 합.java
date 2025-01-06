import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[y][x];
        
        for(int j = 0; j < y; j++){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < x; i++){
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            
            int sum = 0;
            
            for(int k = y1; k <= y2; k++){
                for(int m = x1; m <= x2; m++){
                    sum += arr[k][m];        
                }
            }
            
            sb.append(sum+"\n");
        }
        
        System.out.println(sb.toString());
    }
}