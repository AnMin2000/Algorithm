import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        boolean[] check = new boolean[N + 1];
        
        int count = 0;
        int result = 2;
        
        B1:
        while(true){
            
            int start = 0;
            for(int i = 2; i <= N; i++){
                if(!check[i] && solve(i)){
                    start = i;
                    break;
                }
            }
            
            for(int i = start; i <= N; i+=start){
                if(!check[i]){
                    check[i] = true;
                    count++;
                    if(count == K) {
                    	result = i;
                    	break B1;
                    }
                    
                }
            }
        }
        
        System.out.println(result);
    }
    
    static boolean solve(int i){
        for(int j = 2; j <= Math.sqrt(i); j++){
            if(i % j == 0) return false;
        }                
        return true;
    }
}