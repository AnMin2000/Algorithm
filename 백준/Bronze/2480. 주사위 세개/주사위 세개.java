import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        if(a == b && b == c) System.out.println((10000 + (1000 * a)));
        else if(a == b && a != c || a != b && a == c) System.out.println((1000 + (100 * a)));
        else if(a == b && b != c || a != b && b == c) System.out.println((1000 + (100 * b)));
        else if(c == b && c != a || c != b && c == a) System.out.println((1000 + (100 * c)));
        else {
            int tmp = Math.max(a,b);
            tmp = Math.max(tmp, c);
            System.out.println(tmp * 100);
        }
    }
}