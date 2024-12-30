import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int j = 0; j < n; j++){
            
            Stack<Character> stack = new Stack<>();
            
            String line = sc.next();
            
            for(int i = 0; i < line.length(); i++){
                
                char ch = line.charAt(i);
                
                if(stack.isEmpty()) stack.push(ch);
                else if(stack.peek() == '(' && ch == ')') stack.pop();
                else stack.push(ch);
            }
            
           if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}