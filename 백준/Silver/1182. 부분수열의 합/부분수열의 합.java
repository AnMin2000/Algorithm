import java.util.*;
import java.io.*;

class Main{
    static int count = 0;
    static int N;
    static int S;
    static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        dfs(0, 0);
        
        System.out.println(S == 0 ? count - 1 : count);
      
    }
    static void dfs(int start, int sum){
        if(sum == S){
            count++;
        }
        for(int i = start; i < N; i++){
            dfs(i + 1, sum + arr[i]);
        }
    }
}