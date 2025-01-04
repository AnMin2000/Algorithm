import java.util.*;
import java.io.*;
class Main{
    static long A, B;
    static Queue<Long> queue = new LinkedList<>();
    static long result = -1;
    static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        map.put(A, 1);
        queue.offer(A);
        
        bfs();
        
        System.out.println(result);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            long num = queue.poll();
            
            if(num * 2 <= B && !map.containsKey(num * 2)){
                queue.add(num * 2);
                map.put(num * 2, map.get(num) + 1);
                
                if(num * 2 == B){
                    result = map.get(num * 2);
                    return;
                }
            }
            if(num * 10 + 1 <= B && !map.containsKey(num * 10 + 1)){
                queue.add(num * 10 + 1);
                map.put(num * 10 + 1, map.get(num) + 1);
                
                if(num * 10 + 1 == B){
                    result = map.get(num * 10 + 1);
                    return;
                }
            }
            
        }
    }
}