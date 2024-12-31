import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        
        int len = text.length();
        
        int result = 0;
        int ctn = 0;
        
        int start = 0;
        int end = 2;
        String[] target = new String[]{"c=", "c-", "d-", "lj", "nj", "s=", "z="};
        
        while(start <= len && end <= len){
            String tmp = text.substring(start, end);
            
            
            
            if(end + 1 <= len && text.substring(start, end + 1).equals("dz=") ){
                ctn++;
                start = end + 1;
                end += 3;
                continue;
            }
            
            boolean state = false;
            
            for(int i = 0; i < 7; i++){
            	if(tmp.equals(target[i])){
                    start = end;
                    end += 2;
                    state = true;
                    ctn++;
                    break;
                }  
            }
            
            if(!state){
                start++;
                end++;
                ctn++;
            }
        }
        if(len - start >= 0) System.out.println(ctn + len - start);
        else System.out.println(ctn);
    }
}