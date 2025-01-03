import java.util.*;
import java.io.*;
class Main{

    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(st.nextToken());
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            

            if(n % i == 0) {
                count++;
                if(count == m){
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }

}