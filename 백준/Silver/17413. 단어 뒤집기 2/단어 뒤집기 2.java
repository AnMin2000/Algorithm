import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        boolean state = true;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '<' || ch  == ' ') {
            	while(!stack.isEmpty())	sb.append(stack.pop());
            }
            
            if(ch == '<') state = false;
            
            if(state){
                if(ch == ' ') sb.append(' ');
                else stack.push(ch);
            } 
            else if(!state) sb.append(ch);
            
            if(ch == '>') state = true;
            
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        System.out.println(sb.toString());
    }
}