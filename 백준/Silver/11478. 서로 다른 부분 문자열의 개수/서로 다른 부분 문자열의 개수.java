import java.util.*;
import java.io.*;
class Main{
    static String s;
    static int len;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        len = s.length();
        for(int j = 0; j < len; j++) {
        	for(int i = j; i < len; i++) {
        		set.add(s.substring(j, i + 1));
        	}
        }
 
        System.out.println(set.size());
    }

}