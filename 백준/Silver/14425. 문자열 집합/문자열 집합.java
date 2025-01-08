import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) arr[i] = br.readLine();
        
        Arrays.sort(arr);
        
        int ctn = 0;
        for(int i = 0; i < M; i++){
            if(Arrays.binarySearch(arr, br.readLine()) >= 0) ctn++;
        }
        System.out.println(ctn);
    }
}