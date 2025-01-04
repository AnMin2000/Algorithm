import java.util.*;
import java.io.*;

class Main{
    
	static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N == K){
            System.out.println(0);
            return;
        }

        
        bfs(N, 0);

    }
    static void bfs(int sum, int count){
        int[] visit = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sum);
        visit[sum] = 1;
        
        while(!queue.isEmpty()){
            int value = queue.poll(); // 큐에서 나온 값이 현재값 >> 배열[큐] 는 횟수
            
           
            for(int i = 0; i < 3; i++){
            	int next = 0; 
                if(i == 0){
                	next = value + 1;
                }
                else if(i == 1){
                	next = value - 1;
                }
                else{
                	next = value * 2;
                }
                if(next == K){
                    System.out.println(visit[value]);
                    return;
                }
                if(next >= 0 && next < 100001 && visit[next] == 0) {
                	visit[next] = visit[value] + 1;
                	queue.offer(next);
                }
            }
        }
        
        
        
    }
}