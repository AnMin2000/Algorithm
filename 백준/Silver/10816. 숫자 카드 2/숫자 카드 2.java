import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st2.nextToken());
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            
            int start = 0;
            int end = n;
            
            while(start < end){
                int mid = (start + end) / 2;
                if(arr[mid] < arr2[i]) start = mid + 1;
                else end = mid;
            }
            
            int start2 = 0;
            int end2 = n;
            
            while(start2 < end2){
                int mid = (start2 + end2) / 2;
                if(arr[mid] <= arr2[i]) start2 = mid + 1;
                else end2 = mid;
            }
            sb.append((end2 - start) + " ");
        }
        System.out.println(sb.toString());
    }
}