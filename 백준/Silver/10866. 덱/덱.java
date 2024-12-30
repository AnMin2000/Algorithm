import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Deque<String> deque = new ArrayDeque<>(); 
        
        StringBuilder sb = new StringBuilder();
        
        for(int j = 0; j < n; j++){
            
            String tmp = br.readLine();
            String[] arr = tmp.split(" ");

            String s = arr[0];
            if(s.equals("push_front")) { // 앞으로 넣기
                deque.offerFirst(arr[1]);
            }
            else if(s.equals("push_back")) { // 뒤로 넣기
                deque.offerLast(arr[1]);
            }
            else if(s.equals("pop_front")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.pollFirst()+"\n");
            }
            else if(s.equals("pop_back")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.pollLast()+"\n");
            }
            else if(s.equals("size")){
                sb.append(deque.size()+"\n");
            }
            else if(s.equals("empty")){
                if(deque.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(s.equals("front")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.peekFirst() + "\n");
            }
            else if(s.equals("back")){
                if(deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.peekLast() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}