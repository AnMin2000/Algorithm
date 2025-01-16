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
	static int[] dp;
	static boolean[] visit;
	static List<Node>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[100001];
		for(int i = 0; i <= 100000; i++) list[i] = new ArrayList<>();
		
		dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		visit = new boolean[100001];
		
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
			int curStart = curNode.end;
			int curWeight = curNode.weight;
			
			if(!visit[curStart]) {
				visit[curStart] = true;
				
				for(int i = 0; i < 3; i++) {
					if(i == 0) { // 빼기 1 (가중치 + 1)
						if(curStart - 1 >= 0 && curWeight + 1 < dp[curStart - 1]) {
							dp[curStart - 1] = curWeight + 1;
							pq.offer(new Node(curStart - 1, dp[curStart - 1]));
						}
					}
					else if(i == 1) { // 더하기 1 (가중치 + 1)
						if(curStart + 1 <= 100000 && curWeight + 1 < dp[curStart + 1]) {
							dp[curStart + 1] = curWeight + 1;
							pq.offer(new Node(curStart + 1, dp[curStart + 1]));
						}
					}
					else { // 곱하기 2
						if(curStart * 2 <= 100000 && curWeight < dp[curStart * 2]) {
							dp[curStart * 2] = curWeight;
							pq.offer(new Node(curStart * 2, dp[curStart * 2]));
						}
					}
				}
			}
			
		}
	}
}