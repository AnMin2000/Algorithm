import java.io.*;
import java.util.*;

class Main{
	static List<Integer>[] list;
	static boolean[] visit;
	static int count;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 0;
		StringBuilder sb = new StringBuilder();
		while(true) {
			T++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			if(N == 0 && V == 0) break;
			
			visit = new boolean[N + 1];
			count = 0;
			
			list = new ArrayList[N + 1];
			for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
			for(int i = 0; i < V; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				list[y].add(x);
				list[x].add(y);
			}
			
			int ctn = 0;
			for(int i = 1; i <= N; i++) {
				if(!visit[i]) {
					if(bfs(i)) ctn++;
				}
			}
			if(ctn == 0) {
				sb.append("Case " + T + ": No trees.").append("\n");
			}
			else if(ctn == 1) {
				sb.append("Case " + T + ": There is one tree.").append("\n");
			}
			else {
				sb.append("Case " + T + ": A forest of " + ctn + " trees.").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static boolean bfs(int start) {
		visit[start] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		int node = 0; int volt = 0;
		while(!queue.isEmpty()) {
			int next = queue.poll();
			node++;
			visit[next] = true;
			for(int s : list[next]) {
				volt++;
				if(!visit[s]) {
					queue.offer(s);
				}
			}
		}
		return (node - 1) * 2 == volt ? true : false;
	}
}