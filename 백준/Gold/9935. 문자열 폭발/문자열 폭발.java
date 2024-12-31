import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String target = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        

        
        for(int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);
            
            stack.push(ch);
            
            if(stack.size() >= target.length()){
                
                boolean state = true;
                
                for(int k = 0; k < target.length(); k++){
                    if(stack.get(stack.size() - target.length() + k) != target.charAt(k)){
                        state =false;
                        break;
                    }
                }
                
                if(state){
                    for(int k = 0; k < target.length(); k++) stack.pop();
                }
            }
        }
        
        if(stack.isEmpty()) System.out.println("FRULA");
        else{
        	StringBuilder sb = new StringBuilder();
            for(char ch : stack) sb.append(ch);
            System.out.println(sb.toString());
        }
    }
}