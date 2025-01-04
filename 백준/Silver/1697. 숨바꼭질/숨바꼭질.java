import java.util.*;
import java.io.*;

class Main{
    
	static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N ==0 && K == 0){
            System.out.println(0);
            return;
        }

        
        bfs(N, 0);

    }
    static void bfs(int sum, int count){
        int[] visit = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sum);
        visit[sum] = 0;
        
        while(!queue.isEmpty()){
            int value = queue.poll();
            
            if(value == K){
                System.out.println(visit[value]);
                return;
            }
            for(int i = 0; i < 3; i++){
                if(i == 0){
                    if(value + 1 >= 0 && value + 1 < 100001 && visit[value + 1] == 0){
                        visit[value + 1] = visit[value] + 1;
                        queue.offer(value + 1);
                    }
                }
                else if(i == 1){
                    if(value - 1 >= 0 && value - 1 < 100001 && visit[value - 1] == 0){
                        visit[value - 1] = visit[value] + 1;
                        queue.offer(value - 1);
                    }
                }
                else{
                    if(value * 2 >= 0 && value * 2 < 100001 && visit[value * 2] == 0){
                        visit[value * 2] = visit[value] + 1;
                        queue.offer(value * 2);
                    }
                }
            }
        }
        
        
        
    }
}