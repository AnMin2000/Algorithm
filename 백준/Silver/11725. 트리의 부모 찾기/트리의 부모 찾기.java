import java.io.*;
import java.util.*;

class Main{
	
	static int n;
	static List<Integer>[] list;
	static boolean[] visit;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		
		list = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
		
		visit = new boolean[n + 1];
		arr = new int[n + 1];
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			list[y].add(x);
			list[x].add(y);
		}
		
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= n; i++) sb.append(arr[i]+"\n");
		System.out.println(sb.toString());
	}
	
	static void dfs(int prev) {
		
		for(int num : list[prev]) {
			if(!visit[num]) {
				visit[num] = true;
				arr[num] = prev;
				dfs(num);
			}
		}
	}

}