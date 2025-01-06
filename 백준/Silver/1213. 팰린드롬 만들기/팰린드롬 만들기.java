import java.util.*;
import java.io.*;

class Main{
    

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        int[] arr = new int[26];
        for(int i = 0; i < text.length(); i++){
            arr[text.charAt(i) - 'A']++;
        } 
        
        int mid = 0;
        int index = 0;
        for(int i = 0; i < 26; i++){
            if(arr[i] % 2 == 1) {
                mid++;
                index = i;
            }
        }
        
        if(mid > 1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < 26; j++){
            for(int i = 0; i < arr[j] / 2; i++){
            	char ch = (char)('A'+ j);
                sb.append(ch);
            }
        }
        
        String tmp = sb.toString();
        StringBuilder sb2 = new StringBuilder(tmp);
        sb2.reverse();

        
        if(mid == 1){
        	char ch = (char)('A' + index);
            sb.append(ch);
        }
        
        sb.append(sb2.toString());
        
        System.out.println(sb.toString());
        
    }
   
}