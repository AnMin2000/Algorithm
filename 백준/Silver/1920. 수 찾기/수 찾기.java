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
        
        for(int j = 0; j < m; j++)
        {
            int in = Arrays.binarySearch(prev, next[j]);
            
            if(in < 0) sb.append("0\n");
            else sb.append("1\n");
        }
        
        System.out.println(sb.toString());
    }
}