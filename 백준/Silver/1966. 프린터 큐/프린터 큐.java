import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int target = 0;
            
            List<Integer> list = new ArrayList<>();
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++){
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[] {j, priority});
                list.add(priority);
                if(j == index) target = priority;
            }
            Collections.sort(list, Collections.reverseOrder());
            
            int ctn = 1;
            while(list.get(0) != target){
                if(queue.peek()[1] == list.get(0)) {
                    queue.poll();
                    list.get(0);
                    list.remove(0);
                    ctn++;
                }
                else{
                    queue.offer(queue.poll());
                }
            }
            while(true){
                if(queue.peek()[0] == index) break;
                else if(target == queue.peek()[1]){
                    queue.poll();
                    ctn++;
                }
                else queue.poll();
            }
            System.out.println(ctn);
        }
        
        
    }
}