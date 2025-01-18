import java.util.*;
import java.io.*;

class Node{
	int end;
	int weight;
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}
class Main{
	static int n, m;
	static List<Node>[] list;
	static int[] dp;
	static boolean[] visit;
	static int INF = 1_000_000_001;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		
		dp = new int[n + 1];
		visit = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		bfs(start);
		System.out.println(dp[end]);
	}
	static void bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o2.weight - o1.weight;
			}
		});
		pq.offer(new Node(start, INF));
		dp[start] = INF;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int s = curNode.end; // 시작 지점
			int w = curNode.weight; // 끝지점
			
			if(!visit[s]) {
				visit[s] = true;
				
				for(Node tmp : list[s]) {
					int next = tmp.end;
					int nextWei = Math.min(w, tmp.weight);
					
					if(!visit[next] && dp[next] < nextWei) {
						
						dp[next] = nextWei;
						pq.offer(new Node(next, dp[next]));
					}
				}
			}
		}
		return;
	}
	
}