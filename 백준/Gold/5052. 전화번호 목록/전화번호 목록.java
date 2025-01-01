import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            
            int m = Integer.parseInt(br.readLine());
            String[] arr = new String[m];
            
            for(int j = 0; j < m; j++)  arr[j] = br.readLine();
            Arrays.sort(arr);
            
            boolean state = true;
            
            for(int k = 0; k < m - 1; k++){
                if(arr[k + 1].startsWith(arr[k])){
                    sb.append("NO\n");
                    state = false;
                    break;
                }
                
            }
            if(state) sb.append("YES\n");
        }
        
        System.out.println(sb.toString());
    }
}