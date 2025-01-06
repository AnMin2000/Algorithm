import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double sum = 0;
        
        
        double level = 0;
        
        for(int i = 0; i < 20; i++){
            String[] arr = br.readLine().split(" ");
            
            if(arr[2].equals("P")) continue;
            
            long tmp = arr[1].charAt(0) - '0';
            sum += tmp;
            //System.out.println(tmp);
            if(arr[2].equals("A+")) level += (4.5 * tmp) ;
            else if(arr[2].equals("A0")) level += (4 * tmp);
            else if(arr[2].equals("B+")) level += (3.5 * tmp);
            else if(arr[2].equals("B0")) level += (3 * tmp);
            else if(arr[2].equals("C+")) level += (2.5 * tmp);
            else if(arr[2].equals("C0")) level += (2 * tmp);
            else if(arr[2].equals("D+")) level += (1.5 * tmp);
            else if(arr[2].equals("D0")) level += (1 * tmp);
            else if(arr[2].equals("F")) level += 0;
        }
        
        System.out.println(level / sum);
        
        
    }
}