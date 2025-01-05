import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if(sex == 1){ // 남자일때 배수
                
                for(int k = num; k <= n; k++){
                	if(k % num == 0) arr[k] = Math.abs(arr[k] - 1); 
                }
            }
            else if(sex == 2){ // 여자일때 대칭제일 큰놈
                
                int front = num - 1;
                int end = num + 1;
                arr[num] = Math.abs(arr[num] - 1);
                while(front >= 1 && end <= n && arr[front] == arr[end]){
                    arr[front] = arr[end] = Math.abs(arr[end] - 1);
                    front--;
                    end++;
                } 
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i] + " ");
            if(i % 20 == 0 && n > 20) sb.append("\n");
        }
        

        
        System.out.println(sb.toString());
    }
}