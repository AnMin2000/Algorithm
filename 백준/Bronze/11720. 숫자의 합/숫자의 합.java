import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String s = br.readLine();
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            int ch = s.charAt(i) - '0';
            sum += ch;
        }
        
        System.out.println(sum);
    }
}