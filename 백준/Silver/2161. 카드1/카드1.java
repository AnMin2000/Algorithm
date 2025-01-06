import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) queue.offer(i);
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(!queue.isEmpty()) {
            if(i % 2 == 0) sb.append(queue.poll() + " ");
            else queue.offer(queue.poll());
            i++;
        }
        System.out.println(sb.toString());
    }
}