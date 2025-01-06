import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        
        int[] num = new int[9];
        
        for(int i = 0; i < text.length(); i++){
            int n = text.charAt(i) - '0';
            if(n == 9) num[6]++;
            else num[n]++;
        }
        
        int max = 0;
        for(int i = 0; i < 9; i++){
            if(i == 6) max = Math.max(max, num[i] % 2 == 0 ? num[i] / 2 : num[i] / 2 + 1);
            else max = Math.max(max, num[i]);
        }
        System.out.println(max);
    }
}