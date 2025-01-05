import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int child = 1;
        int parent = 1;
        int count = 1;
        int check = 1;
        
        B1:
        while(count != n){
            if(count % 2 == 1){
                child = 1;
                parent = count + 1;
                check++;
                if(check == n) break;
                while(parent > 1){
                    child++;
                    parent--;   
                    check++;
                    if(check == n) break B1;
                }
            }
            else{
                child = count + 1;
                parent = 1;
                check++;
                if(check == n) break;
                while(child > 1){
                    child--;
                    parent++;
                    check++;
                    if(check == n) break B1;
                }
            }
            
            
            count++;
        }
        
        System.out.println(child + "/" + parent);
        
        
    }
}