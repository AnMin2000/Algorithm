import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            
            if( m == 0) stack.pop();
            else stack.push(m);
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }
}