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
	static int ss, ee;
	static int n;
	static int INF = 200_000_001;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 정점 개수
		int m = Integer.parseInt(st.nextToken()); // 간선 개수
	
		dp = new int[n + 1];

		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 시작점
			int e = Integer.parseInt(st.nextToken()); // 끝점
			int w = Integer.parseInt(st.nextToken()); // 가중치
			
			list[s].add(new Node(e, w));
			list[e].add(new Node(s, w));
		}

		st = new StringTokenizer(br.readLine());
		ss = Integer.parseInt(st.nextToken());
		ee = Integer.parseInt(st.nextToken());		
		
		int tmp1 = bfs(1, ss) + bfs(ss, ee) + bfs(ee, n);
		int tmp2 = bfs(1, ee) + bfs(ee, ss) + bfs(ss, n);

		int result = Math.min(tmp1, tmp2);

		System.out.println(result >= INF ? -1 : result);

		
	}
	static int bfs(int start, int end) {
		visit = new boolean[n + 1];
		Arrays.fill(dp, INF);
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
		return dp[end];
	}
}