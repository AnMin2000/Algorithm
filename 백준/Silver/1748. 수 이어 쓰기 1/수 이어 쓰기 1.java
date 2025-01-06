import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        
        int number = Integer.parseInt(n);
        if(number < 10) {
        	System.out.println(number);
        	return;
        }
        int len = n.length();
        
        String text = "";
        
        for(int i = 0; i < len - 1; i++) text += "9";
        
        int num = Integer.parseInt(text);
        
        number = (number - num) * len--;
        
        while(num != 0){
            number += ((num - (num / 10)) * len--);
            num /= 10;
        }
        
        System.out.println(number);
        
    }
}