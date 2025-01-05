import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] box = new int[5][5];
        boolean[][] visit = new boolean[5][5];
        
        for(int j = 0; j < 5; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 5; i++){
                box[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        boolean fuck = false;
        
        for(int j = 0; j < 5; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 5; i++){
                int n = Integer.parseInt(st.nextToken());
                
                if(fuck) continue;
                count++;
                B1:
                for(int k = 0; k < 5; k++){
                    for(int m = 0; m < 5; m++){
                        if(box[k][m] == n) {
                            visit[k][m] = true;
                            break B1;
                        } 

                    }
                }
               
                int ctn = 0;
                for(int k = 0; k < 5; k++){
                    boolean state = true;
                    for(int m = 0; m < 5; m++){
                        if(!visit[k][m]) {
                            state = false;
                            break;
                        }
                    }
                    if(state) ctn++;
                }
                for(int k = 0; k < 5; k++){
                    boolean state = true;
                    for(int m = 0; m < 5; m++){
                        if(!visit[m][k]) {
                            state = false;
                            break;
                        }
                    }
                    if(state) ctn++;
                }
                
                boolean state1 = true;
                 for(int k = 0; k < 5; k++){
                    
                    if(!visit[k][k]) {
                        state1 = false;
                        break;
                    }
                }
                if(state1) ctn++;
                
                boolean state2 = true;
                 for(int k = 0; k < 5; k++){
                    
                    if(!visit[k][4 - k]) {
                        state2 = false;
                        break;
                    }
                }
                if(state2) ctn++;
                
                if(ctn >= 3) fuck = true;
                
                
            }
        }
        System.out.println(count);
    }
}