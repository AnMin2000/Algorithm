import java.io.*;
import java.util.*;

class Node{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}

class Main{
	static boolean[] visit;
	static List<Node>[] list;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 정점 개수
		int m = Integer.parseInt(br.readLine()); // 간선 개수
		
		list = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		dp = new int[n + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		
		while(m-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		bfs(start);
		
		System.out.println(dp[end]);
		
	}
	static void bfs(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}
		});
		
		pq.offer(new Node(start, 0));
		dp[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curEnd = curNode.end;
			int curWei = curNode.weight;
			
			if(!visit[curEnd]) {
				visit[curEnd] = true;
				
				for(Node tmp : list[curEnd]) { // 이 아래에선 curEnd가 시작 노드가 되는거임 + nextEnd가 끝 노드가 되는거고
					int nextEnd = tmp.end; // 다음 정점
					int nextWei = tmp.weight; // 다음 가중치
					
					if(!visit[nextEnd] && dp[curEnd] + nextWei < dp[nextEnd]) {
						dp[nextEnd] = dp[curEnd] + nextWei;
						pq.offer(new Node(nextEnd, dp[nextEnd]));
					}
					
				}
			}
		}
	}
}