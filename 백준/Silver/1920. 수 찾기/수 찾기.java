import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) prev[i] = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        int[] next = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) next[i] = Integer.parseInt(st2.nextToken());
        
        Arrays.sort(prev);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < m; i++)
        {
            int start = 0;
            int end = n - 1;
            
            while(true){
                int mid = (start + end) / 2;
                
                if(prev[mid] == next[i]){
                    sb.append("1\n");
                    break;
                }
                else if(prev[mid] < next[i]) start = mid + 1;
                else end = mid - 1;
                
                if(start > end){
                    sb.append("0\n");
                    break;
                }
            }

        }        
        System.out.println(sb.toString());
    }
}