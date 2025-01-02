// 99(1 ~ 99) // 147 741
import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        
        if(Integer.parseInt(n) < 100) System.out.println(n);
        else{
            
            int sum = 99;
            
            for(int i = 100; i <= Integer.parseInt(n); i++){
                String tmp = String.valueOf(i);
                if(tmp.charAt(2) - tmp.charAt(1) == tmp.charAt(1) - tmp.charAt(0)) sum++;
            }
            
            System.out.println(sum);
            
        }
        
    }
}