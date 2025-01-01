import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        String T = br.readLine();
        
        StringBuilder sb = new StringBuilder(T);
        
        while(sb.length() > S.length()){
            if(sb.charAt(sb.length() - 1) == 'A') {
        	    sb.replace(sb.length() - 1, sb.length(), "");
                if(S.equals(sb.toString())){
                    System.out.println(1);
                    return;
                }
            }

            if(sb.charAt(sb.length() - 1) == 'B') {
                sb.replace(sb.length() - 1, sb.length(), "");
                sb.reverse();
                if(S.equals(sb.toString())){
                    System.out.println(1);
                    return;
                }
            }
        }
        
        System.out.println(0);
    }
}