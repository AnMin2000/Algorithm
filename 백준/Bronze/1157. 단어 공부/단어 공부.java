import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A 65 -- Z 90 -- a 97 -- z 122
        String text = br.readLine();
        
        int[] arr = new int[100];
        
        for(int i = 0; i < text.length(); i++){
            int ch = text.charAt(i);
            
            if(ch >= 65 && ch <= 90) arr[ch]++;
            else arr[ch - 32]++;
        }
        
        int index = 65;
        int value = arr[index];
        
       
        for(int i = 66; i <= 90; i++){
            if(arr[index] < arr[i]){
                index = i;
                value = arr[index];
            }
        }
        char result = (char)index;
        Arrays.sort(arr);
        boolean state = true;
        if(arr[99] == arr[98]) state = false;
        
        if(state) System.out.println(result);
        else System.out.println("?");
        
    }
}