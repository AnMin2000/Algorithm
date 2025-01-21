import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int zero = 0;
        int one = 0;
        
        for(int i = 0; i < n.length(); i++) {
        	if((n.charAt(i) == '0' && i == n.length() - 1) || (n.charAt(i) == '0' && n.charAt(i + 1) == '1')) zero++;
        	else if((n.charAt(i) == '1' && i == n.length() - 1) || n.charAt(i) == '1' && n.charAt(i + 1) == '0')one++;
        }
        
        
        System.out.println(Math.min(zero, one));
    }
}