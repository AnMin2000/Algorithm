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
	static List<Node>[] list;
	static int[] dp;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
		
		int start = Integer.parseInt(br.readLine());
		
		visit = new boolean[n + 1];
		
		dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작점
			int e = Integer.parseInt(st.nextToken()); // 끝점
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			list[s].add(new Node(e, w));
		}
		
		bfs(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			sb.append(dp[i] == Integer.MAX_VALUE ? "INF" : dp[i]).append("\n");

		}
		
		System.out.println(sb.toString());
		
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
			int curStart = curNode.end;
			int curWei = curNode.weight;
			
			if(!visit[curStart]) {
				visit[curStart] = true;
				
				for(Node tmp : list[curStart]) {
					int nextNode = tmp.end;
					int nextWei = tmp.weight;
					if(!visit[nextNode] && dp[curStart] + nextWei < dp[nextNode]) {
						dp[nextNode] = dp[curStart] + nextWei;
						pq.offer(new Node(nextNode, dp[nextNode]));
					}
				}
			}
		}
	}
}