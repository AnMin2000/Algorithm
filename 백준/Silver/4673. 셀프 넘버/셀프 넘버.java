import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 1; i <= 10000; i++){
            
            boolean state = true;
       
            for(int j = 1; j < i; j++){
                int sum = j;
                
                int tmp = sum;
                while(sum != 0){

                	tmp += sum % 10;
                    sum /= 10;
                    
                }
                if(tmp == i) {
                    state = false;
                    break;
                }
            }
            if(state) sb.append(i+"\n");
        }
        
        System.out.println(sb.toString());
        
        
    }
}